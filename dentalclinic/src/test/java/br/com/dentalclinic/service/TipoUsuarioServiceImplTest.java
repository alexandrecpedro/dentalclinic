package br.com.dentalclinic.service;

import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.model.TipoUsuario;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import br.com.dentalclinic.service.impl.TipoUsuarioServiceImpl;
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
public class TipoUsuarioServiceImplTest {
    /** Attributes **/
    @Autowired
    TipoUsuarioServiceImpl tipoUsuarioServiceImpl;

    static ArrayList<TipoUsuario> listaTipoUsuario = new ArrayList<TipoUsuario>();

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
                listaTipoUsuario.add(new TipoUsuario(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void salvar(){
        for(TipoUsuario t : listaTipoUsuario){
            tipoUsuarioServiceImpl.salvar(t);
        }
    }

    @Test
    public void buscarTodos(){
        List<TipoUsuario> todosTiposUsuario = tipoUsuarioServiceImpl.buscarTodos();
        if(todosTiposUsuario.size()<3){
            fail("Falha ao inserir ou buscar todos enderecos");
        }
    }

    @Test
    public void buscarById(){
        for(TipoUsuario t : listaTipoUsuario){
            Optional<TipoUsuario> tipoUsuario2 = tipoUsuarioServiceImpl.buscarById(t.getId());
            if(tipoUsuario2.isEmpty()){
                fail("Falha buscando tipo usuario pelo id.");
            }
            if(!comparaObjetoToString(t,tipoUsuario2.get())){
                fail("Falha buscando tipo usuario pelo id.");
            }

        }
    }

    @Test
    public void findByNome(){
        for(TipoUsuario t : listaTipoUsuario){
            TipoUsuario tipoUsuarioBuscado = tipoUsuarioServiceImpl.buscarByNome(t.getNome());
            if(tipoUsuarioBuscado.getId()!=t.getId()){
                fail("Falha buscando tipo de usuario pelo nome.");
            }
        }
    }

    @Test
    public void atualizar() {
        for(TipoUsuario tipoUsuario : listaTipoUsuario){
            tipoUsuario.setNome("Novo "+tipoUsuario.getNome());
            tipoUsuarioServiceImpl.atualizar(tipoUsuario);
            Optional<TipoUsuario> tipousuarioLido = tipoUsuarioServiceImpl.buscarById(tipoUsuario.getId());
            if(tipousuarioLido.isEmpty()){
                fail("Falha atualizando tipo usuario, retornou um objeto vazio.");
            }
            if(!comparaObjetoToString(tipoUsuario, tipousuarioLido.get())){
                fail("Falha atualizando tipo usuario, objeto não é igual ao objeto enviado para atualização.");
            }
        }
    }

    @Test
    public void deletar(){
        for(TipoUsuario tipoUusario : listaTipoUsuario){
            tipoUsuarioServiceImpl.deletar(tipoUusario.getId());
        }
        if(tipoUsuarioServiceImpl.buscarTodos().size()>0){
            fail("Falha deletando os tipos de usuario.");
        }
    }
}
