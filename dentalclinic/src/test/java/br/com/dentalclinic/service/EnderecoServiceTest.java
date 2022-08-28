package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.EnderecoDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnderecoServiceTest {
    /** Attributes **/
    EnderecoService enderecoService = new EnderecoService(new EnderecoDaoImpl(new ConfiguracaoJDBC()));

    /** Tests **/
    @Test
    public void salvar() {}

    @Test
    public void buscarById() {}

    @Test
    public void atualizar() {}

    @Test
    public void deletar() {}
}