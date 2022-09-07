package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.repository.IPacienteRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteServiceImpl implements IService<Paciente> {
    /** Attribute **/
    @Autowired
    private IPacienteRepository pacienterepository;

    /** Constructor **/
    public PacienteServiceImpl(IPacienteRepository pacienterepository) {
        this.pacienterepository = pacienterepository;
    }

    /** Methods **/
    @Override
    public Paciente salvar(Paciente paciente) {
        if (!paciente.equals(null)) {
            pacienterepository.save(paciente);
        }
        return paciente;
    }

    @Override
    public Optional<Paciente> buscarById(Integer id) {
        return pacienterepository.findById(id);
    }

    @Override
    public Paciente atualizar(Paciente paciente) {
        return pacienterepository.saveAndFlush(paciente);
    }

    @Override
    public void deletar(Integer id) {
        pacienterepository.deleteById(id);
    }
}
