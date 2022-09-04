package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.TipoUsuarioRepository;
import br.com.dentalclinic.repository.UsuarioRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IService<Usuario> {
    /** Attribute **/
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    /** Methods **/
    @Override
    public Usuario salvar(Usuario usuario) {
        if (!usuario.equals(null)) {
            usuarioRepository.save(usuario);
        }
        return usuario;
    }

    public Optional<Usuario> buscarById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }

//    public Usuario mapperDTOToEntity(UsuarioDTO usuarioDTO) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        Usuario usuario = objectMapper.convertValue(usuarioDTO, Usuario.class);
//        return usuario;
//    }
//
//    public UsuarioDTO mapperEntityToDTO(Usuario usuario) {
//        ObjectMapper objectMapper = new ObjectMapper();
//        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuario, UsuarioDTO.class);
//        return usuarioDTO;
//    }
}
