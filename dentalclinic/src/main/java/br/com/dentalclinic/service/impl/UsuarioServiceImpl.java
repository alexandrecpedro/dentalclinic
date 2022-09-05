package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.UsuarioRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IService<Usuario> {
    /** Attribute **/
    @Autowired
    private UsuarioRepository usuarioRepository;

    /** Constructor **/
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

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

    public List<Usuario> buscarTodos(){return usuarioRepository.findAll();}

    public Usuario atualizar(Usuario usuario) {
        return usuarioRepository.saveAndFlush(usuario);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
