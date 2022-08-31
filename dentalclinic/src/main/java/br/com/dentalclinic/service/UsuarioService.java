package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    /** Attribute **/
    @Autowired
    private UsuarioRepository usuarioRepository;

    /** Constructor **/
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /** Methods **/
    public Usuario salvar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarById(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
