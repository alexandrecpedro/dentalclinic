package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoService {
    /** Attribute **/
    @Autowired
    private EnderecoRepository enderecoRepository;

    /** Constructor **/
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    /** Methods **/
    public Endereco salvar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public Optional<Endereco> buscarById(Integer id) {
        return enderecoRepository.findById(id);
    }

    public Endereco atualizar(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }

    public void deletar(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
