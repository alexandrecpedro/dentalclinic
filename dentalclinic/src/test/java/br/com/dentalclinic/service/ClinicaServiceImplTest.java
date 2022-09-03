package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.ClinicaDaoImpl;
import br.com.dentalclinic.service.impl.ClinicaServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClinicaServiceImplTest {
    /** Attributes **/
    @Autowired
    ClinicaServiceImpl clinicaServiceImpl;

    /** Tests **/
    @Test
    public void insertingAndCheckingTest() {

    }

    @Test
    public void buscarById() {}

    @Test
    public void atualizar() {}

    @Test
    public void deletar() {}
}