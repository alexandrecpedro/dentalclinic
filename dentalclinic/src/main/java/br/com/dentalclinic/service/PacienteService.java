package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService {
    /** Attribute **/
    @Autowired
    private PacienteRepository pacienterepository;

    /** Constructor **/
    public PacienteService(PacienteRepository pacienterepository) {
        this.pacienterepository = pacienterepository;
    }

    /** Methods **/
    public Paciente salvar(Paciente paciente) {
        return pacienterepository.save(paciente);
    }

    public Optional<Paciente> buscarById(Integer id) {
        return pacienterepository.findById(id);
    }

    public Paciente atualizar(Paciente paciente) {
        return pacienterepository.save(paciente);
    }

    public void deletar(Integer id) {
        pacienterepository.deleteById(id);
    }
}
