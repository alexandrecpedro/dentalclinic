package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.TipoUsuario;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {
    /** Attribute **/
    private IDao<TipoUsuario> tipoUsuarioIDao;

    /** Constructor **/
    public TipoUsuarioService(IDao<TipoUsuario> tipoUsuarioIDao) {
        this.tipoUsuarioIDao = tipoUsuarioIDao;
    }

    /** Methods **/
    public TipoUsuario salvar(TipoUsuario tipoUsuario) {
        return tipoUsuarioIDao.salvar(tipoUsuario);
    }

    public TipoUsuario buscarById(Integer id) {
        return tipoUsuarioIDao.buscarById(id);
    }

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        return tipoUsuarioIDao.atualizar(tipoUsuario);
    }

    public void deletar(Integer id) {
        tipoUsuarioIDao.deletar(id);
    }
}
