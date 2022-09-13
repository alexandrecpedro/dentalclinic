package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.IUsuarioRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IService<UsuarioDTO> {
    /** Attribute **/
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    /** Methods **/
    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapperDTOToEntity(usuarioDTO);
        int idTipoUsuario = usuario.getTipoUsuario().getId();

        if (tipoUsuarioService.ifTipoUsuarioExists(idTipoUsuario)) {
            TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioService.buscarById(idTipoUsuario).get();
            TipoUsuario tipoUsuario = new TipoUsuario(tipoUsuarioDTO);
            usuario.setTipoUsuario(tipoUsuario);
            usuario = usuarioRepository.save(usuario);
        }

        usuarioDTO = mapperEntityToDTO(usuario);
        return usuarioDTO;
    }

    public Optional<UsuarioDTO> buscarById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarByEmail(String email){return usuarioRepository.findByEmail(email);}

    public List<UsuarioDTO> buscarTodos(){return usuarioRepository.findAll();}

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public boolean ifUsuarioExists(int id){
        return usuarioRepository.existsById(id);
    }

    public Usuario mapperDTOToEntity(UsuarioDTO usuarioDTO) {
        ObjectMapper objectMapper = new ObjectMapper();
        Usuario usuario = objectMapper.convertValue(usuarioDTO, Usuario.class);
        return usuario;
    }

    public UsuarioDTO mapperEntityToDTO(Usuario usuario) {
        ObjectMapper objectMapper = new ObjectMapper();
        UsuarioDTO usuarioDTO = objectMapper.convertValue(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }

}
