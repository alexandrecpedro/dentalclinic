package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.model.Usuario;
import br.com.dentalclinic.service.impl.TipoUsuarioServiceImpl;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;

@SpringBootTest
class UsuarioServiceImplTest {
    /** Attributes **/
    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    TipoUsuarioServiceImpl tipoUsuarioService;

    static ArrayList<UsuarioDTO> listaUsuario = new ArrayList();
    static ArrayList<TipoUsuarioDTO> listaTipoUsuario = new ArrayList();

    public boolean ComparaObjetoToString(Object o1, Object o2){
        System.out.println(o1.toString());
        System.out.println(o2.toString());
        System.out.println(o1.toString().equals(o2.toString()));
        if(o1.toString().equals(o2.toString())){
            return true;
        }
        return false;
    }

    @BeforeAll
    static public void init(){


    }

    @Test
    public void SalvarTipoUsuarios(){
        BufferedReader reader;

        try{
            reader = new BufferedReader(new FileReader("./TipoUsuarios.txt"));
            String line = reader.readLine();
            while(line != null){
                listaTipoUsuario.add(new TipoUsuario(line));
                tipoUsuarioService.salvar(new TipoUsuario(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Tests **/
    @Test
    public void salvarUsuarios() {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("./Usuario.txt"));
            String line = reader.readLine();
            while(line!=null){
                String[] arrayLineSplit = line.split(";");
                listaUsuario.add(new Usuario(arrayLineSplit[0],arrayLineSplit[1],tipoUsuarioService.buscarByNome(arrayLineSplit[2])));
                line = reader.readLine();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(Usuario user : listaUsuario){
            usuarioServiceImpl.salvar(user);
        }
    }

    @Test
    public void buscarTodos(){
        List<Usuario> listaUsuariosBuscados = usuarioServiceImpl.buscarTodos();
        if(listaUsuariosBuscados.size()!=listaUsuario.size()){
            fail("Falha Buscando Todos Usuarios.");
        }
    }

    @Test
    public void buscarById() {
        for(Usuario u : listaUsuario){
            Optional<Usuario> u2 = usuarioServiceImpl.buscarById(u.getId());
            if(u2.isEmpty() || !ComparaObjetoToString(u,u2)){
                fail("Falha buscando usuario pelo id.");
            }
        }
    }

    @Test
    public void buscarByEmail() {
        for(Usuario u : listaUsuario){
            Optional<Usuario> u2 = usuarioServiceImpl.buscarByEmail(u.getEmail());
            if(u2.isEmpty() || !ComparaObjetoToString(u,u2)){
                fail("Falha buscando usuario pelo id.");
            }
        }
    }

    @Test
    public void atualizar() {
        for(Usuario u : listaUsuario){
            u.setSenha("XXXX");
            usuarioServiceImpl.atualizar(u);
        }
        for(Usuario u : listaUsuario){
            if(!ComparaObjetoToString(u,usuarioServiceImpl.buscarById(u.getId()))){
                fail("Falha Atualizando Usuario.");
            }
        }
    }

    @Test
    public void deletar() {
        for(Usuario u : listaUsuario){
            usuarioServiceImpl.deletar(u.getId());
        }
        if(usuarioServiceImpl.buscarTodos().size()>0){
            fail("Falha Deletando Usuarios");
        }
    }
}