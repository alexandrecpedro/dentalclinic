package br.com.dentalclinic.service.impl;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.repository.EnderecoRepository;
import br.com.dentalclinic.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements IService<Endereco> {
    /** Attribute **/
    @Autowired
    private EnderecoRepository enderecoRepository;

    /** Constructor **/
    //public EnderecoServiceImpl(EnderecoRepository enderecoRepository) {
    //    this.enderecoRepository = enderecoRepository;
    //}

    /** Methods **/
    @Override
    public Endereco salvar(Endereco endereco) {
        if (!endereco.equals(null)) {
            enderecoRepository.save(endereco);
        }
        return endereco;
    }

    public Optional<Endereco> buscarById(Integer id) {
        return enderecoRepository.findById(id);
    }

    public Endereco atualizar(Endereco endereco) {
        return enderecoRepository.saveAndFlush(endereco);
    }

    public void deletar(Integer id) {
        enderecoRepository.deleteById(id);
    }

    public List<Endereco> buscarTodos(){
        return enderecoRepository.findAll();
    }
}
