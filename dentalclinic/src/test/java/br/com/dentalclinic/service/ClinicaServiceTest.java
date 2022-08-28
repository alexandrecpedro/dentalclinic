package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.ClinicaDaoImpl;
import org.junit.jupiter.api.Test;

class ClinicaServiceTest {
    /** Attributes **/
    ClinicaService clinicaService = new ClinicaService(new ClinicaDaoImpl(new ConfiguracaoJDBC()));

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