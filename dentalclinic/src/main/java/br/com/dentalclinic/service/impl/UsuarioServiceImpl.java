package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.exception.BadRequestException;
import br.com.dentalclinic.exception.ResourceNotFoundException;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.IUsuarioRepository;
import br.com.dentalclinic.service.IService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IService<UsuarioDTO>, UserDetailsService {
    /** Attribute **/
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private TipoUsuarioServiceImpl tipoUsuarioService;

    /** Methods **/
    @Override
    public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(usuarioDTO);
        int idTipoUsuario = usuario.getTipoUsuario().getId();

        if (tipoUsuarioService.ifTipoUsuarioExists(idTipoUsuario)) {
            TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioService.buscarById(idTipoUsuario).orElseThrow(() -> {
                throw new ResourceNotFoundException("Tipo de Usuário não encontrado");
            });
            TipoUsuario tipoUsuario = new TipoUsuario(tipoUsuarioDTO);
            usuario.setTipoUsuario(tipoUsuario);
            usuario = usuarioRepository.save(usuario);
        }

        usuarioDTO = new UsuarioDTO(usuario);
        return usuarioDTO;
    }

    @Override
    public Optional<UsuarioDTO> buscarById(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> {
            throw new ResourceNotFoundException("Usuário não encontrado");
        });
        UsuarioDTO usuarioDTO = mapperEntityToDTO(usuario);
        return Optional.ofNullable(usuarioDTO);
    }

    public Optional<UsuarioDTO> buscarByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email).orElseThrow(() -> {
            throw new ResourceNotFoundException("Usuário não encontrado");
        });
        UsuarioDTO usuarioDTO = mapperEntityToDTO(usuario);
        return Optional.ofNullable(usuarioDTO);
    }

    @Override
    public List<UsuarioDTO> buscarTodos(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();

        for (Usuario usuario : usuarios){
            //UsuarioDTO usuarioDTO = mapperEntityToDTO(usuario);
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
            usuarioDTOS.add(usuarioDTO);
        }
         return usuarioDTOS;
    }
    @Override
    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO) {
        Usuario usuario = mapperDTOToEntity(usuarioDTO);
        usuario = usuarioRepository.saveAndFlush(usuario);
        usuarioDTO = mapperEntityToDTO(usuario);
        return usuarioDTO;
    }
    @Override
    public void deletar(Integer id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new BadRequestException("Usuário inexistente!");
        }
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return usuarioRepository.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException("Usuário não encontrado!"));
    }
}
