package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.dto.PacienteDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.IPacienteRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IService<PacienteDTO> {
    /** Attribute **/
    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private EnderecoServiceImpl enderecoService;

    /** Methods **/
    @Override
    public PacienteDTO salvar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapperDTOToEntity(pacienteDTO);
        int idEndereco = paciente.getEndereco().getId();
        int idUsuario = paciente.getUsuario().getId();

        if (enderecoService.ifEnderecoExists(idEndereco) && usuarioService.ifUsuarioExists(idUsuario)) {
            EnderecoDTO enderecoDTO = enderecoService.buscarById(idEndereco).get();
            Endereco endereco = new Endereco(enderecoDTO);
            UsuarioDTO usuarioDTO = usuarioService.buscarById(idUsuario).get();
            Usuario usuario = new Usuario(usuarioDTO);

            paciente.setEndereco(endereco);
            paciente.setUsuario(usuario);

            paciente = pacienteRepository.save(paciente);
        }

        pacienteDTO = mapperEntityToDTO(paciente);

        return pacienteDTO;
    }

    @Override
    public Optional<PacienteDTO> buscarById(Integer id) {
        Paciente paciente = pacienteRepository.findById(id).get();
        PacienteDTO pacienteDTO = mapperEntityToDTO(paciente);
        return Optional.ofNullable(pacienteDTO);
    }

    @Override
    public List<PacienteDTO> buscarTodos(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();

        for (Paciente paciente : pacientes){
            PacienteDTO pacienteDTO = mapperEntityToDTO(paciente);
            pacienteDTOS.add(pacienteDTO);
        }
        return pacienteDTOS;
    }

    @Override
    public PacienteDTO atualizar(PacienteDTO pacienteDTO) {
        Paciente paciente = mapperDTOToEntity(pacienteDTO);
        paciente = pacienteRepository.saveAndFlush(paciente);
        pacienteDTO = mapperEntityToDTO(paciente);
        return pacienteDTO;
    }

    @Override
    public void deletar(Integer id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        }
    }

    public boolean ifPacienteExists(int id){
        return pacienteRepository.existsById(id);
    }

    public Paciente mapperDTOToEntity(PacienteDTO pacienteDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Paciente paciente = objectMapper.convertValue(pacienteDTO, Paciente.class);
        return paciente;
    }

    public PacienteDTO mapperEntityToDTO(Paciente paciente) {
        ObjectMapper objectMapper = new ObjectMapper();
        PacienteDTO pacienteDTO = objectMapper.convertValue(paciente, PacienteDTO.class);
        return pacienteDTO;
    }

}
