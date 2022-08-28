package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.PacienteDaoImpl;
import org.junit.jupiter.api.Test;

class PacienteServiceTest {
    /** Attributes **/
    PacienteService pacienteService = new PacienteService(new PacienteDaoImpl(new ConfiguracaoJDBC()));

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