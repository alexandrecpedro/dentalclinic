package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Clinica;
import org.springframework.stereotype.Service;

@Service
public class ClinicaService {
    /** Attribute **/
    private IDao<Clinica> clinicaIDao;

    /** Constructor **/
    public ClinicaService(IDao<Clinica> clinicaIDao) {
        this.clinicaIDao = clinicaIDao;
    }

    /** Methods **/
    public Clinica salvar(Clinica clinica) {
        return clinicaIDao.salvar(clinica);
    }

    public Clinica buscarById(Integer id) {
        return clinicaIDao.buscarById(id);
    }

    public Clinica atualizar(Clinica clinica) {
        return clinicaIDao.atualizar(clinica);
    }

    public void deletar(Integer id) {
        clinicaIDao.deletar(id);
    }
}
