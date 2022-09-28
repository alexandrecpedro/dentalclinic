package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.service.impl.TipoUsuarioServiceImpl;
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
public class TipoUsuarioServiceImplTest {
    /** Attributes **/
    @Autowired
    TipoUsuarioServiceImpl tipoUsuarioServiceImpl;

    static ArrayList<TipoUsuarioDTO> listaTipoUsuarioDTO = new ArrayList<>();

    public boolean comparaObjetoToString(Object o1, Object o2){
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
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("./TipoUsuarios.txt"));
            String line = reader.readLine();
            while(line != null){
                listaTipoUsuarioDTO.add(new TipoUsuarioDTO(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @Order(1)
    public void salvar(){
        for(int i =0;i<listaTipoUsuarioDTO.size();i++){
            listaTipoUsuarioDTO.set(i,tipoUsuarioServiceImpl.salvar(listaTipoUsuarioDTO.get(i)));
        }
    //    for(TipoUsuarioDTO t : listaTipoUsuarioDTO){
    //        tipoUsuarioServiceImpl.salvar(t);
    //    }
    }

    @Test
    @Order(2)
    public void buscarTodos(){
        List<TipoUsuarioDTO> todosTiposUsuario = tipoUsuarioServiceImpl.buscarTodos();
        if(todosTiposUsuario.size()<3){
            fail("Falha ao inserir ou buscar todos enderecos");
        }
    }

    @Test
    @Order(3)
    public void buscarById(){
        for(TipoUsuarioDTO t : listaTipoUsuarioDTO){
            Optional<TipoUsuarioDTO> tipoUsuario2 = tipoUsuarioServiceImpl.buscarById(t.getId());
            if(tipoUsuario2.isEmpty()){
                fail("Falha buscando tipo usuario pelo id.");
            }
            if(!comparaObjetoToString(t,tipoUsuario2.get())){
                fail("Falha buscando tipo usuario pelo id.");
            }

        }
    }

    @Test
    @Order(4)
    public void findByNome(){
        for(TipoUsuarioDTO t : listaTipoUsuarioDTO){
            TipoUsuarioDTO tipoUsuarioBuscado = tipoUsuarioServiceImpl.buscarByNome(t.getNome());
            if(tipoUsuarioBuscado.getId()!=t.getId()){
                fail("Falha buscando tipo de usuario pelo nome.");
            }
        }
    }

    @Test
    @Order(5)
    public void atualizar() {
        for(TipoUsuarioDTO tipoUsuario : listaTipoUsuarioDTO){
            tipoUsuario.setNome("Novo "+tipoUsuario.getNome());
            tipoUsuarioServiceImpl.atualizar(tipoUsuario);
            Optional<TipoUsuarioDTO> tipousuarioLido = tipoUsuarioServiceImpl.buscarById(tipoUsuario.getId());
            if(tipousuarioLido.isEmpty()){
                fail("Falha atualizando tipo usuario, retornou um objeto vazio.");
            }
            if(!comparaObjetoToString(tipoUsuario, tipousuarioLido.get())){
                fail("Falha atualizando tipo usuario, objeto não é igual ao objeto enviado para atualização.");
            }
        }
    }

    @Test
    @Order(6)
    public void deletar(){
        for(TipoUsuarioDTO tipoUusario : listaTipoUsuarioDTO){
            tipoUsuarioServiceImpl.deletar(tipoUusario.getId());
        }
        if(tipoUsuarioServiceImpl.buscarTodos().size()>0){
            fail("Falha deletando os tipos de usuario.");
        }
    }
}
