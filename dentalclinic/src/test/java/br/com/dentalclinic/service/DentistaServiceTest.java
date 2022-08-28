package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.DentistaDaoImpl;
import org.junit.jupiter.api.Test;

class DentistaServiceTest {
    /** Attributes **/
    DentistaService dentistaService = new DentistaService(new DentistaDaoImpl(new ConfiguracaoJDBC()));

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