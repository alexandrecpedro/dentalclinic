package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.repository.IUsuarioRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements IService<Usuario> {
    /** Attribute **/
    @Autowired
    private IUsuarioRepository IUsuarioRepository;

    /** Constructor **/
    public UsuarioServiceImpl(IUsuarioRepository IUsuarioRepository) {
        this.IUsuarioRepository = IUsuarioRepository;
    }

    /** Methods **/
    @Override
    public Usuario salvar(Usuario usuario) {
        if (!usuario.equals(null)) {
            IUsuarioRepository.save(usuario);
        }
        return usuario;
    }

    public Optional<Usuario> buscarById(Integer id) {
        return IUsuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarByEmail(String email){return IUsuarioRepository.findByEmail(email);}

    public List<Usuario> buscarTodos(){return IUsuarioRepository.findAll();}

    public Usuario atualizar(Usuario usuario) {
        return IUsuarioRepository.saveAndFlush(usuario);
    }

    public void deletar(Integer id) {
        IUsuarioRepository.deleteById(id);
    }
}
