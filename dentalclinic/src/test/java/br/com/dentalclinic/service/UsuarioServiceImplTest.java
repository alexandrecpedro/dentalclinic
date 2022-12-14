package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.service.impl.TipoUsuarioServiceImpl;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.*;
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
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
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

    /** Tests **/
    @Test
    @Order(1)
    public void salvarUsuarios() {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("./TipoUsuarios.txt"));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                listaTipoUsuario.add(new TipoUsuarioDTO(line));
                listaTipoUsuario.set(i,tipoUsuarioService.salvar(listaTipoUsuario.get(i)));
                i++;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try{
            reader = new BufferedReader(new FileReader("./Usuario.txt"));
            String line = reader.readLine();
            while(line!=null){
                String[] arrayLineSplit = line.split(";");
                //TipoUsuarioDTO tipoUsuarioDTO = tipoUsuarioService.buscarByNome(arrayLineSplit[2]);
                listaUsuario.add(new UsuarioDTO(arrayLineSplit[0],arrayLineSplit[1],tipoUsuarioService.buscarByNome(arrayLineSplit[2])));
                line = reader.readLine();
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i = 0;i<listaUsuario.size();i++){
            listaUsuario.set(i,usuarioServiceImpl.salvar(listaUsuario.get(i)));
        }
    }

    @Test
    @Order(2)
    public void buscarTodos(){
        List<UsuarioDTO> listaUsuariosBuscados = usuarioServiceImpl.buscarTodos();
        if(listaUsuariosBuscados.size()!=listaUsuario.size()){
            fail("Falha Buscando Todos Usuarios.");
        }
    }

    @Test
    @Order(3)
    public void buscarById() {
        for(UsuarioDTO u : listaUsuario){
            Optional<UsuarioDTO> u2 = usuarioServiceImpl.buscarById(u.getId());
            if(u2.isEmpty() || !ComparaObjetoToString(u,u2.get())){
                fail("Falha buscando usuario pelo id.");
            }
        }
    }

    @Test
    @Order(4)
    public void buscarByEmail() {
        for(UsuarioDTO u : listaUsuario){
            Optional<UsuarioDTO> u2 = usuarioServiceImpl.buscarByEmail(u.getEmail());
            if(u2.isEmpty() || !ComparaObjetoToString(u,u2.get())){
                fail("Falha buscando usuario pelo id.");
            }
        }
    }

    @Test
    @Order(5)
    public void atualizar() {
        for(UsuarioDTO u : listaUsuario){
            u.setSenha("XXXX");
            usuarioServiceImpl.atualizar(u);
        }
        for(UsuarioDTO u : listaUsuario){
            if(!ComparaObjetoToString(u,usuarioServiceImpl.buscarById(u.getId()).get())){
                fail("Falha Atualizando Usuario.");
            }
        }
    }

    @Test
    @Order(6)
    public void deletar() {
        for(UsuarioDTO u : listaUsuario){
            usuarioServiceImpl.deletar(u.getId());
        }
        if(usuarioServiceImpl.buscarTodos().size()>0){
            fail("Falha Deletando Usuarios");
        }
    }
}