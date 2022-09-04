package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.PacienteDTO;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.repository.EnderecoRepository;
import br.com.dentalclinic.repository.PacienteRepository;
import br.com.dentalclinic.repository.UsuarioRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteServiceImpl implements IService<Paciente> {
    /** Attribute **/
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    /** Methods **/
    @Override
    public Paciente salvar(Paciente paciente) {
        if (!paciente.equals(null)) {
            pacienteRepository.save(paciente);
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscarById(Integer id) {
        return pacienteRepository.findById(id);
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        return pacienteRepository.saveAndFlush(paciente);
    }

    @Override
    public void deletar(Integer id) {
        pacienteRepository.deleteById(id);
    }

//    public Paciente mapperDTOToEntity(PacienteDTO pacienteDTO) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Paciente paciente = objectMapper.convertValue(pacienteDTO, Paciente.class);
//        return paciente;
//    }
//
//    public PacienteDTO mapperEntityToDTO(Paciente paciente) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        PacienteDTO pacienteDTO = objectMapper.convertValue(paciente, PacienteDTO.class);
//        return pacienteDTO;
//    }
}
