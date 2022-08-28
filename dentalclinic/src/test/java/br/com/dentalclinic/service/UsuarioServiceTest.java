package br.com.dentalclinic.service;

import br.com.dentalclinic.dao.ConfiguracaoJDBC;
import br.com.dentalclinic.dao.impl.UsuarioDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioServiceTest {
    /** Attributes **/
    UsuarioService usuarioService = new UsuarioService(new UsuarioDaoImpl(new ConfiguracaoJDBC()));

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