package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class PacienteService {
    /** Attribute **/
    private IDao<Paciente> pacienteIDao;

    /** Constructor **/
    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    /** Methods **/
    public Paciente salvar(Paciente paciente) {
        return pacienteIDao.salvar(paciente);
    }

    public Paciente buscarById(Integer id) {
        return pacienteIDao.buscarById(id);
    }

    public Paciente atualizar(Paciente paciente) {
        return pacienteIDao.atualizar(paciente);
    }

    public void deletar(Integer id) {
        pacienteIDao.deletar(id);
    }
}
