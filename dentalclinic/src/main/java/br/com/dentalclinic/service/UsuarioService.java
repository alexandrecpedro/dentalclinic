package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    /** Attribute **/
    private IDao<Usuario> usuarioIDao;

    /** Constructor **/
    public UsuarioService(IDao<Usuario> usuarioIDao) {
        this.usuarioIDao = usuarioIDao;
    }

    /** Methods **/
    public Usuario salvar(Usuario usuario) {
        return usuarioIDao.salvar(usuario);
    }

    public Usuario buscarById(Integer id) {
        return usuarioIDao.buscarById(id);
    }

    public Usuario atualizar(Usuario usuario) {
        return usuarioIDao.atualizar(usuario);
    }

    public void deletar(Integer id) {
        usuarioIDao.deletar(id);
    }
}
