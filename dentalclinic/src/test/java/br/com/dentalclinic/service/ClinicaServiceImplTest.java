package br.com.dentalclinic.service;

import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.service.impl.ClinicaServiceImpl;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
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
class ClinicaServiceImplTest {
    /** Attributes **/
    @Autowired
    ClinicaServiceImpl clinicaServiceImpl;

    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    static ArrayList<Clinica> listaClinica = new ArrayList<Clinica>();
    static ArrayList<Endereco> listaEndereco = new ArrayList<Endereco>();

    //#######################################################
    //Funcao para comparar clinicas
    public boolean comparaObjetoToString(Object o1, Object o2){
        System.out.println(o1.toString());
        if(o1.toString().equals(o2.toString())){
            return true;
        }
        return false;
    }

    /** Tests **/

    @BeforeAll
    static public void init(){
        //Populando a lista inicial com 16 enderecos para permitir a criacao das clinicas
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./Enderecos.txt"));
            String line = reader.readLine();
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                Endereco end = new Endereco(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
                listaEndereco.add(end);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void salvar() {
        //#######################################################
        //Salvando os 16 Enderecos na base de dados para criacao das Clinicas
        //#######################################################
        //for(Endereco e : listaEndereco){
        //    enderecoServiceImpl.salvar(e);
        //}
        //#######################################################
        //Lendo o arquivo de Clinicas para criar e salvar os objetos na base de dados
        //#######################################################
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("./Clinicas.txt"));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                Clinica clinica = new Clinica(atrArray[0],atrArray[1],listaEndereco.get(i++));
                clinicaServiceImpl.salvar(clinica);
                listaClinica.add(clinica);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    public void buscarTodos(){
        List<Clinica> todasClinicasDb = clinicaServiceImpl.buscarTodos();
        if(todasClinicasDb.size()<16){
            fail("Falha ao inserir ou buscar todos enderecos");
        }
    }

    @Test
    public void buscarById() {
        for(Clinica c1 : listaClinica){
            Optional<Clinica> c2 = clinicaServiceImpl.buscarById(c1.getId());
            if(c2.isEmpty()){
                fail("Falha buiscando Clinica na BD.");
            }
            if(!comparaObjetoToString(c1, c2.get())){
                fail("Falha buiscando Clinica na BD.");
            }
        }
    }

    @Test
    public void atualizar() {
        int i = 1;
        for(Clinica c : listaClinica){
            c.setNomeFantasia("Clinica Teste "+i++);
            clinicaServiceImpl.atualizar(c);
        }
        List<Clinica> listaClinicas2 = clinicaServiceImpl.buscarTodos();
        i = 1;
        for(Clinica c : listaClinicas2){
            if(!c.getNomeFantasia().equals("Clinica Teste "+i++)){
                fail("Falha no teste de atualizacao");
            }
        }
    }

    @Test
    public void deletar() {
        for(Clinica c : listaClinica){
            clinicaServiceImpl.deletar(c.getId());
        }
        List<Clinica> listaClinica2 = clinicaServiceImpl.buscarTodos();
        if(listaClinica2.size()>0){
            fail("Falha ao deletar todas entradas");
        }
    }
}