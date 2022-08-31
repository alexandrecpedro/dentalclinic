package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicaService {
    /** Attribute **/
    @Autowired
    private ClinicaRepository clinicaRepository;

    /** Constructor **/
    public ClinicaService(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    /** Methods **/
    public Clinica salvar(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    public Optional<Clinica> buscarById(Integer id) {
        return clinicaRepository.findById(id);
    }

    public Clinica atualizar(Clinica clinica) {
        return clinicaRepository.save(clinica);
    }

    public void deletar(Integer id) {
        clinicaRepository.deleteById(id);
    }
}
