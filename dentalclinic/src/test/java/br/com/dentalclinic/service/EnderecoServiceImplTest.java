package br.com.dentalclinic.service;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EnderecoServiceImplTest {
    /** Attributes **/
    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    /** Tests **/
    @Test
    public void salvar() {
        //String logradouro, String numero, String complemento, String bairro, String localidade, String uf, String cep
        Endereco end1 = new Endereco();
    }

    @Test
    public void buscarById() {}

    @Test
    public void atualizar() {}

    @Test
    public void deletar() {}
}