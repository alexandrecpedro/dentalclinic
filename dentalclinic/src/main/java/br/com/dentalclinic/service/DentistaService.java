package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Dentista;
import org.springframework.stereotype.Service;

@Service
public class DentistaService {
    /** Attribute **/
    private IDao<Dentista> dentistaIDao;

    /** Constructor **/
    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    /** Methods **/
    public Dentista salvar(Dentista dentista) {
        return dentistaIDao.salvar(dentista);
    }

    public Dentista buscarById(Integer id) {
        return dentistaIDao.buscarById(id);
    }

    public Dentista atualizar(Dentista dentista) {
        return dentistaIDao.atualizar(dentista);
    }

    public void deletar(Integer id) {
        dentistaIDao.deletar(id);
    }
}
