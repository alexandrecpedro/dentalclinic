package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ConsultaDTO;
import br.com.dentalclinic.dto.DentistaDTO;
import br.com.dentalclinic.dto.PacienteDTO;
import br.com.dentalclinic.exception.BadRequestException;
import br.com.dentalclinic.exception.ResourceNotFoundException;
import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.repository.IConsultaRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IService<ConsultaDTO> {
    /** Attribute **/
    @Autowired
    private IConsultaRepository consultaRepository;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private DentistaServiceImpl dentistaService;

    /** Methods **/
    @Override
    public ConsultaDTO salvar(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);
        int idPaciente = consulta.getPaciente().getId();
        int idDentista = consulta.getDentista().getId();

        if (pacienteService.ifPacienteExists(idPaciente) && dentistaService.ifDentistaExists(idDentista)) {
            PacienteDTO pacienteDTO = pacienteService.buscarById(idPaciente).orElseThrow(() -> {
                throw new ResourceNotFoundException("Paciente não encontrado!");
            });
            Paciente paciente = new Paciente(pacienteDTO);
            DentistaDTO dentistaDTO = dentistaService.buscarById(idDentista).orElseThrow(() -> {
                throw new ResourceNotFoundException("Dentista não encontrado!");
            });
            Dentista dentista = new Dentista(dentistaDTO);

            consulta.setPaciente(paciente);
            consulta.setDentista(dentista);
        }

        consultaDTO = new ConsultaDTO(consultaRepository.save(new Consulta(consultaDTO)));
        return consultaDTO;
    }

    @Override
    public Optional<ConsultaDTO> buscarById(Integer id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Consulta não encontrada");
        });
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
        return Optional.ofNullable(consultaDTO);
    }

    @Override
    public List<ConsultaDTO> buscarTodos(){
        List<Consulta> consultas = consultaRepository.findAll();
        List<ConsultaDTO> consultaDTOS = new ArrayList<>();

        for (Consulta consulta : consultas){
            ConsultaDTO consultaDTO = new ConsultaDTO(consulta);
            consultaDTOS.add(consultaDTO);
        }
        return consultaDTOS;
    }

    @Override
    public ConsultaDTO atualizar(ConsultaDTO consultaDTO) {
        Consulta consulta = new Consulta(consultaDTO);
        consulta = consultaRepository.saveAndFlush(consulta);
        consultaDTO = new ConsultaDTO(consulta);
        return consultaDTO;
    }

    @Override
    public void deletar(Integer id) {
        if (consultaRepository.existsById(id)) {
            consultaRepository.deleteById(id);
        } else {
            throw new BadRequestException("Consulta inexistente!");
        }
    }

}
