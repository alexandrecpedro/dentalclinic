package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.repository.TipoUsuarioRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TipoUsuarioServiceImpl implements IService<TipoUsuario> {
    /** Attribute **/
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /** Methods **/
    @Override
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        if (!tipoUsuario.equals(null)) {
            tipoUsuarioRepository.save(tipoUsuario);
        }
        return tipoUsuario;
    }

    public Optional<TipoUsuario> buscarById(Integer id) {
        return tipoUsuarioRepository.findById(id);
    }

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.saveAndFlush(tipoUsuario);
    }

    public void deletar(Integer id) {
        tipoUsuarioRepository.deleteById(id);
    }

//    public TipoUsuario mapperDTOToEntity(TipoUsuarioDTO tipoUsuarioDTO) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        TipoUsuario tipoUsuario = objectMapper.convertValue(tipoUsuarioDTO, TipoUsuario.class);
//        return tipoUsuario;
//    }
//
//    public TipoUsuarioDTO mapperEntityToDTO(TipoUsuario tipoUsuario) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        TipoUsuarioDTO tipoUsuarioDTO = objectMapper.convertValue(tipoUsuario, TipoUsuarioDTO.class);
//        return tipoUsuarioDTO;
//    }
}
