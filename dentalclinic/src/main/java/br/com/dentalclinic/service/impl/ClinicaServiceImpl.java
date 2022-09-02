package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.repository.ClinicaRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicaServiceImpl implements IService<Clinica> {
    /** Attribute **/
    @Autowired
    private ClinicaRepository clinicaRepository;

    /** Constructor **/
    public ClinicaServiceImpl(ClinicaRepository clinicaRepository) {
        this.clinicaRepository = clinicaRepository;
    }

    /** Methods **/
    @Override
    public Clinica salvar(Clinica clinica) {
        if (!clinica.equals(null)) {
            clinicaRepository.save(clinica);
        }
        return clinica;
    }
    @Override
    public Optional<Clinica> buscarById(Integer id) {
        return clinicaRepository.findById(id);
    }
    @Override
    public Clinica atualizar(Clinica clinica) {
        return clinicaRepository.saveAndFlush(clinica);
    }

    @Override
    public void deletar(Integer id) {
        clinicaRepository.deleteById(id);
    }
}
