package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import org.junit.jupiter.api.*;
import org.springframework.beans.BeanUtils;
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
class EnderecoServiceImplTest {
    /** Attributes **/
    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    static ArrayList<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();

    //#######################################################
    //Funcao para comparar enderecos
    //#######################################################
    public boolean comparaObjetoToString(Object o1, Object o2){
        if(o1.toString().equals(o2.toString())){
            return true;
        }
        return false;
    }

    @BeforeAll
    static public void init(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./Enderecos.txt"));
            String line = reader.readLine();
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                EnderecoDTO end = new EnderecoDTO(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
                listaEnderecoDTO.add(end);
                line = reader.readLine();
                BufferedReader.nullReader();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /** Tests **/
    @Test
    @Order(1)
    //#######################################################
    //Rotina teste insercao de enderecos
    //#######################################################
    public void salvar() {

        for(int i=0;i<listaEnderecoDTO.size();i++){
            listaEnderecoDTO.set(i,enderecoServiceImpl.salvar(listaEnderecoDTO.get(i)));
        }

    //    for(EnderecoDTO e : listaEnderecoDTO){
    //        enderecoServiceImpl.salvar(e);
    //    }

    }

    @Test
    @Order(2)
    public void buscarTodos(){
        List<EnderecoDTO> todosEnderecosDb = enderecoServiceImpl.buscarTodos();
        if(todosEnderecosDb.size()<16){
            fail("Falha ao inserir ou buscar todos enderecos");
        }
    }

    @Test
    @Order(3)
    public void buscarById() {
        for(EnderecoDTO e : listaEnderecoDTO){
            Optional<EnderecoDTO> dbEndereco;
            dbEndereco = enderecoServiceImpl.buscarById(e.getId());

            if(dbEndereco.isEmpty()){
                fail("Falha buscando o endereco :"+e.toString());
            }
            else{
                if(!comparaObjetoToString(e,dbEndereco.get())){
                    fail("Falha buscando o endereco :"+e.toString());
                }
            }
        }
    }

    @Test
    @Order(4)
    public void atualizar() {
        for(EnderecoDTO e1: listaEnderecoDTO){
            EnderecoDTO e2 = new EnderecoDTO();
            BeanUtils.copyProperties(e1,e2);
            e2.setNumero("5");
            enderecoServiceImpl.atualizar(e2);
            Endereco e3 = new Endereco();
            enderecoServiceImpl.buscarById(e2.getId());
            if(e3.getNumero()==e1.getNumero()){
                fail("Falha atualizar o numero");
            }
        }
    }

    @Test
    @Order(5)
    public void deletar() {
        for(EnderecoDTO e: listaEnderecoDTO){
            enderecoServiceImpl.deletar(e.getId());
        }
        List<EnderecoDTO> enderecosDb = enderecoServiceImpl.buscarTodos();
        if(enderecosDb.size()>0){
            fail("Falha ao deletar entradas.");
        }
    }
}