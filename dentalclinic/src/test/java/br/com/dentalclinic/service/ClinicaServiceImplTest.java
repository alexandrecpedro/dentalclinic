package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.model.Clinica;
import br.com.dentalclinic.model.Endereco;
import br.com.dentalclinic.service.impl.ClinicaServiceImpl;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
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
class ClinicaServiceImplTest {
    /** Attributes **/
    @Autowired
    ClinicaServiceImpl clinicaServiceImpl;

    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    static ArrayList<ClinicaDTO> listaClinica = new ArrayList<>();
    static ArrayList<EnderecoDTO> listaEndereco = new ArrayList<>();

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
                EnderecoDTO end = new EnderecoDTO(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
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
    @Order(1)
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
            for(int i=0;i<listaEndereco.size();i++){
                listaEndereco.set(i,enderecoServiceImpl.salvar(listaEndereco.get(i)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            reader = new BufferedReader(new FileReader("./Clinicas.txt"));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                ClinicaDTO clinicaDTO = new ClinicaDTO(atrArray[0],atrArray[1],listaEndereco.get(i++));
                listaClinica.add(clinicaServiceImpl.salvar(clinicaDTO));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    @Order(2)
    public void buscarTodos(){
        List<ClinicaDTO> todasClinicasDb = clinicaServiceImpl.buscarTodos();
        if(todasClinicasDb.size()<listaClinica.size()){
            fail("Falha ao inserir ou buscar todos enderecos");
        }
    }

    @Test
    @Order(3)
    public void buscarById() {
        for(ClinicaDTO c1 : listaClinica){
            Optional<ClinicaDTO> c2 = clinicaServiceImpl.buscarById(c1.getId());
            if(c2.isEmpty()){
                fail("Falha buiscando Clinica na BD.");
            }
            if(!comparaObjetoToString(c1, c2.get())){
                fail("Falha buiscando Clinica na BD.");
            }
        }
    }

    @Test
    @Order(4)
    public void buscarByNomeFantasia() {
        for(ClinicaDTO c1 : listaClinica){
            Optional<ClinicaDTO> c2 = clinicaServiceImpl.buscarByNomeFantasia(c1.getNomeFantasia());
            if(c2.isEmpty()){
                fail("Falha buscando Clinica na BD.");
            }
            if(!comparaObjetoToString(c1, c2.get())){
                fail("Falha buscando Clinica na BD.");
            }
        }
    }

    @Test
    @Order(5)
    public void atualizar() {
        int i = 1;
        for(ClinicaDTO c : listaClinica){
            c.setNomeFantasia("Clinica Teste "+i++);
            clinicaServiceImpl.atualizar(c);
        }
        List<ClinicaDTO> listaClinicas2 = clinicaServiceImpl.buscarTodos();
        i = 1;
        for(ClinicaDTO c : listaClinicas2){
            if(!c.getNomeFantasia().equals("Clinica Teste "+i++)){
                fail("Falha no teste de atualizacao");
            }
        }
    }

    @Test
    @Order(6)
    public void deletar() {
        for(ClinicaDTO c : listaClinica){
            clinicaServiceImpl.deletar(c.getId());
        }
        List<ClinicaDTO> listaClinica2 = clinicaServiceImpl.buscarTodos();
        if(listaClinica2.size()>0 || enderecoServiceImpl.buscarTodos().size()>0){
            fail("Falha ao deletar todas entradas");
        }
    }
}