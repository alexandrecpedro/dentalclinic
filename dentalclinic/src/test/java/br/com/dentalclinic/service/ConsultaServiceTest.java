package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.ConsultaDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConsultaServiceTest {
    /** Attributes **/
    ConsultaService consultaService = new ConsultaService(new ConsultaDaoImpl(new ConfiguracaoJDBC()));

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