package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.exception.BadRequestException;
import br.com.dentalclinic.exception.ResourceNotFoundException;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.repository.ITipoUsuarioRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements IService<TipoUsuarioDTO> {
    /** Attribute **/
    @Autowired
    private ITipoUsuarioRepository tipoUsuarioRepository;

    /** Methods **/
    @Override
    public TipoUsuarioDTO salvar(TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuario tipoUsuario = mapperDTOToEntity(tipoUsuarioDTO);
        if (!tipoUsuario.equals(null)) {
            tipoUsuario = tipoUsuarioRepository.save(tipoUsuario);
        } else {
            throw new BadRequestException("Tipo de Usuário já cadastrado!");
        }
        tipoUsuarioDTO = mapperEntityToDTO(tipoUsuario);
        return tipoUsuarioDTO;
    }

    @Override
    public Optional<TipoUsuarioDTO> buscarById(Integer id) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Tipo de Usuário não encontrado");
        });
        TipoUsuarioDTO tipoUsuarioDTO = mapperEntityToDTO(tipoUsuario);
        return Optional.ofNullable(tipoUsuarioDTO);
    }

    @Override
    public List<TipoUsuarioDTO> buscarTodos() {
        List<TipoUsuario> tipoUsuarioList = tipoUsuarioRepository.findAll();
        List<TipoUsuarioDTO> tipoUsuarioDTOS = new ArrayList<>();

        for (TipoUsuario tipoUsuario: tipoUsuarioList) {
            TipoUsuarioDTO tipoUsuarioDTO = mapperEntityToDTO(tipoUsuario);
            tipoUsuarioDTOS.add(tipoUsuarioDTO);
        }
        return tipoUsuarioDTOS;
    }

    @Override
    public TipoUsuarioDTO atualizar(TipoUsuarioDTO tipoUsuarioDTO) {
        TipoUsuario tipoUsuario = mapperDTOToEntity(tipoUsuarioDTO);
        tipoUsuario = tipoUsuarioRepository.saveAndFlush(tipoUsuario);
        tipoUsuarioDTO = mapperEntityToDTO(tipoUsuario);
        return tipoUsuarioDTO;
    }

    @Override
    public void deletar(Integer id) {
        if (tipoUsuarioRepository.existsById(id)) {
            tipoUsuarioRepository.deleteById(id);
        } else {
            throw new BadRequestException("Tipo de Usuário inexistente!");
        }
    }

    public TipoUsuarioDTO buscarByNome(String nome) {
        TipoUsuario tipoUsuario = tipoUsuarioRepository.findByNome(nome);
        TipoUsuarioDTO tipoUsuarioDTO = mapperEntityToDTO(tipoUsuario);
        return tipoUsuarioDTO;
    }

    public Boolean ifTipoUsuarioExists(int id) {
        return tipoUsuarioRepository.existsById(id);
    }

    public TipoUsuario mapperDTOToEntity(TipoUsuarioDTO tipoUsuarioDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        TipoUsuario tipoUsuario = objectMapper.convertValue(tipoUsuarioDTO, TipoUsuario.class);
        return tipoUsuario;
    }

    public TipoUsuarioDTO mapperEntityToDTO(TipoUsuario tipoUsuario) {
        ObjectMapper objectMapper = new ObjectMapper();
        TipoUsuarioDTO tipoUsuarioDTO = objectMapper.convertValue(tipoUsuario, TipoUsuarioDTO.class);
        return tipoUsuarioDTO;
    }
}
