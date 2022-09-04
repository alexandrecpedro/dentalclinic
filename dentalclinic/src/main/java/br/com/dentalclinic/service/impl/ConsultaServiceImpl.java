package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ConsultaDTO;
import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.repository.ConsultaRepository;
import br.com.dentalclinic.repository.DentistaRepository;
import br.com.dentalclinic.repository.PacienteRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConsultaServiceImpl implements IService<Consulta> {
    /** Attributes **/
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private DentistaRepository dentistaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    /** Methods **/
    @Override
    public Consulta salvar(Consulta consulta) {
        if (!consulta.equals(null)) {
            consultaRepository.save(consulta);
        }
        return consulta;
    }

    @Override
    public Optional<Consulta> buscarById(Integer id) {
        return consultaRepository.findById(id);
    }

    @Override
    public Consulta atualizar(Consulta consulta) {
        return consultaRepository.saveAndFlush(consulta);
    }

    @Override
    public void deletar(Integer id) {
        consultaRepository.deleteById(id);
    }

//    public Consulta mapperDTOToEntity(ConsultaDTO consultaDTO) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Consulta consulta = objectMapper.convertValue(consultaDTO, Consulta.class);
//        return consulta;
//    }
//
//    public ConsultaDTO mapperEntityToDTO(Consulta consulta) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        ConsultaDTO consultaDTO = objectMapper.convertValue(consulta, ConsultaDTO.class);
//        return consultaDTO;
//    }
}
