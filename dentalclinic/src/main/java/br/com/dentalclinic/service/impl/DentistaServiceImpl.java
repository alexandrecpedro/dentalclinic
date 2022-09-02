package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.repository.DentistaRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DentistaServiceImpl implements IService<Dentista> {
    /** Attribute **/
    @Autowired
    private DentistaRepository dentistaRepository;

    /** Constructor **/
    public DentistaServiceImpl(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    /** Methods **/
    @Override
    public Dentista salvar(Dentista dentista) {
        if (!dentista.equals(null)) {
            dentistaRepository.save(dentista);
        }
        return dentista;
    }

    @Override
    public Optional<Dentista> buscarById(Integer id) {
        return dentistaRepository.findById(id);
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        return dentistaRepository.saveAndFlush(dentista);
    }

    @Override
    public void deletar(Integer id) {
        dentistaRepository.deleteById(id);
    }
}
