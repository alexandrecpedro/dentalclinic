package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.IDao;
import br.com.dentalclinic.model.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    /** Attribute **/
    private IDao<Endereco> enderecoIDao;

    /** Constructor **/
    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoIDao = enderecoIDao;
    }

    /** Methods **/
    public Endereco salvar(Endereco endereco) {
        return enderecoIDao.salvar(endereco);
    }

    public Endereco buscarById(Integer id) {
        return enderecoIDao.buscarById(id);
    }

    public Endereco atualizar(Endereco endereco) {
        return enderecoIDao.atualizar(endereco);
    }

    public void deletar(Integer id) {
        enderecoIDao.deletar(id);
    }
}
