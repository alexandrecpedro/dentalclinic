package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.repository.IDentistaRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DentistaServiceImpl implements IService<Dentista> {
    /** Attribute **/
    @Autowired
    private IDentistaRepository IDentistaRepository;

    /** Constructor **/
    public DentistaServiceImpl(IDentistaRepository IDentistaRepository) {
        this.IDentistaRepository = IDentistaRepository;
    }

    /** Methods **/
    @Override
    public Dentista salvar(Dentista dentista) {
        if (!dentista.equals(null)) {
            IDentistaRepository.save(dentista);
        }
        return dentista;
    }

    @Override
    public Optional<Dentista> buscarById(Integer id) {
        return IDentistaRepository.findById(id);
    }

    @Override
    public Dentista atualizar(Dentista dentista) {
        return IDentistaRepository.saveAndFlush(dentista);
    }

    @Override
    public void deletar(Integer id) {
        IDentistaRepository.deleteById(id);
    }
}
