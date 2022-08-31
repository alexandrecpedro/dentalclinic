package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Dentista;
import br.com.dentalclinic.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DentistaService {
    /** Attribute **/
    @Autowired
    private DentistaRepository dentistaRepository;

    /** Constructor **/
    public DentistaService(DentistaRepository dentistaRepository) {
        this.dentistaRepository = dentistaRepository;
    }

    /** Methods **/
    public Dentista salvar(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    public Optional<Dentista> buscarById(Integer id) {
        return dentistaRepository.findById(id);
    }

    public Dentista atualizar(Dentista dentista) {
        return dentistaRepository.save(dentista);
    }

    public void deletar(Integer id) {
        dentistaRepository.deleteById(id);
    }
}
