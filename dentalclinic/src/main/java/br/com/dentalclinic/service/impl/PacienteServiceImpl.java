package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.dto.PacienteDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.exception.BadRequestException;
import br.com.dentalclinic.exception.ResourceNotFoundException;
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
        Paciente paciente = new Paciente(pacienteDTO);
        int idEndereco = paciente.getEndereco().getId();
        int idUsuario = paciente.getUsuario().getId();
        Endereco endereco;
        EnderecoDTO enderecoDTO;
        Usuario usuario;
        UsuarioDTO usuarioDTO;

        if (enderecoService.ifEnderecoExists(idEndereco)){
            enderecoDTO = enderecoService.buscarById(idEndereco).orElseThrow(() -> {
                throw new ResourceNotFoundException("Endereço não encontrado");
            });
            endereco = new Endereco(enderecoDTO);

        } else {
            enderecoDTO = enderecoService.salvar(new EnderecoDTO(pacienteDTO.getEndereco()));
            endereco = new Endereco(enderecoDTO);
        }
            paciente.setEndereco(endereco);

        if(usuarioService.ifUsuarioExists(idUsuario)) {

            usuarioDTO = usuarioService.buscarById(idUsuario).orElseThrow(() -> {
                throw new ResourceNotFoundException("Usuário não encontrado");
            });
            usuario = new Usuario(usuarioDTO);
        }else {
            usuarioDTO = usuarioService.salvar(new UsuarioDTO(pacienteDTO.getUsuario()));
            usuario = new Usuario(usuarioDTO);
        }
            paciente.setUsuario(usuario);

            paciente = pacienteRepository.save(paciente);

        pacienteDTO = new PacienteDTO(paciente);

        return pacienteDTO;
    }

    @Override
    public Optional<PacienteDTO> buscarById(Integer id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Paciente não encontrado");
        });
        PacienteDTO pacienteDTO = new PacienteDTO(paciente);
        return Optional.ofNullable(pacienteDTO);
    }

    @Override
    public List<PacienteDTO> buscarTodos(){
        List<Paciente> pacientes = pacienteRepository.findAll();
        List<PacienteDTO> pacienteDTOS = new ArrayList<>();

        for (Paciente paciente : pacientes){
            PacienteDTO pacienteDTO = new PacienteDTO(paciente);
            pacienteDTOS.add(pacienteDTO);
        }
        return pacienteDTOS;
    }

    @Override
    public PacienteDTO atualizar(PacienteDTO pacienteDTO) {
        Paciente paciente = new Paciente(pacienteDTO);
        paciente = pacienteRepository.saveAndFlush(paciente);
        pacienteDTO = new PacienteDTO(paciente);
        return pacienteDTO;
    }

    @Override
    public void deletar(Integer id) {
        if (pacienteRepository.existsById(id)) {
            pacienteRepository.deleteById(id);
        } else {
            throw new BadRequestException("Paciente inexistente!");
        }
    }

    public boolean ifPacienteExists(int id){
        return pacienteRepository.existsById(id);
    }

}
