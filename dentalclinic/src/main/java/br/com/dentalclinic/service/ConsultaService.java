package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Consulta;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {
    /** Attribute **/
    private IDao<Consulta> consultaIDao;

    /** Constructor **/
    public ConsultaService(IDao<Consulta> consultaIDao) {
        this.consultaIDao = consultaIDao;
    }

    /** Methods **/
    public Consulta salvar(Consulta consulta) {
        return consultaIDao.salvar(consulta);
    }

    public Consulta buscarById(Integer id) {
        return consultaIDao.buscarById(id);
    }

    public Consulta atualizar(Consulta consulta) {
        return consultaIDao.atualizar(consulta);
    }

    public void deletar(Integer id) {
        consultaIDao.deletar(id);
    }
}
