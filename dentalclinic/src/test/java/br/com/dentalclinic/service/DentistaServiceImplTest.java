package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.*;
import br.com.dentalclinic.model.*;
import br.com.dentalclinic.service.impl.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DentistaServiceImplTest {
    /** Attributes **/
    @Autowired
    DentistaServiceImpl dentistaServiceImpl;

    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    @Autowired
    ClinicaServiceImpl clinicaServiceImpl;

    @Autowired
    TipoUsuarioServiceImpl tipoUsuarioServiceImpl;

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    static List<TipoUsuarioDTO> listaTipoUsuarioDTO = new ArrayList<>();

    static List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();

    static List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();

    static List<ClinicaDTO> listaClinicaDTO = new ArrayList<>();

    static List<DentistaDTO> listaDentistaDTO = new ArrayList<>();


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
    @Test
    @Order(1)
    public void salvar() {
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("./TipoUsuarios.txt"));
            String line = reader.readLine();
            while(line != null){
                listaTipoUsuarioDTO.add(new TipoUsuarioDTO(line));
                line = reader.readLine();
            }
            for(int i =0;i<listaTipoUsuarioDTO.size();i++) {
                listaTipoUsuarioDTO.set(i, tipoUsuarioServiceImpl.salvar(listaTipoUsuarioDTO.get(i)));
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
                listaUsuarioDTO.add(new UsuarioDTO(arrayLineSplit[0],arrayLineSplit[1],tipoUsuarioServiceImpl.buscarByNome(arrayLineSplit[2])));
                line = reader.readLine();
            }
            for(int i = 0;i<listaUsuarioDTO.size();i++){
                listaUsuarioDTO.set(i,usuarioServiceImpl.salvar(listaUsuarioDTO.get(i)));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new FileReader("./Enderecos.txt"));
            String line = reader.readLine();
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                EnderecoDTO end = new EnderecoDTO(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
                listaEnderecoDTO.add(end);
                line = reader.readLine();
            }
            for(int i=0;i<listaEnderecoDTO.size();i++){
                listaEnderecoDTO.set(i,enderecoServiceImpl.salvar(listaEnderecoDTO.get(i)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new FileReader("./Clinicas.txt"));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                ClinicaDTO clinicaDTO = new ClinicaDTO(atrArray[0],atrArray[1],listaEnderecoDTO.get(i++));
                listaClinicaDTO.add(clinicaServiceImpl.salvar(clinicaDTO));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            reader = new BufferedReader(new FileReader("./Dentistas.txt"));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");


                //public DentistaDTO(String nome, String sobrenome, String cro, Usuario usuario, Clinica clinica)
                DentistaDTO dentistaDTO = new DentistaDTO(atrArray[0],atrArray[1],atrArray[2] ,listaUsuarioDTO.get(i) , listaClinicaDTO.get(i) );
                listaDentistaDTO.add(dentistaServiceImpl.salvar(dentistaDTO));
                i++;
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
        List<DentistaDTO> listaDentistaDTO2 = dentistaServiceImpl.buscarTodos();
        if(listaDentistaDTO2.size()<listaDentistaDTO.size()){
            fail("Falha ao inserir ou buscar todos dentista");
        }
    }


    @Test
    @Order(3)
    public void buscarById() {
        for(DentistaDTO d1 : listaDentistaDTO){
            Optional<DentistaDTO> d2 = dentistaServiceImpl.buscarById(d1.getId());
            if(d2.isEmpty()){
                fail("Falha buiscando Clinica na BD.");
            }
            if(!comparaObjetoToString(d1, d2.get())){
                fail("Falha buiscando Clinica na BD.");
            }
        }
    }

    @Test
    @Order(4)
    public void atualizar() {
        int i = 1;
        for(DentistaDTO d : listaDentistaDTO){
            d.setNome("Dentista Teste "+i++);
            dentistaServiceImpl.atualizar(d);
        }
        List<DentistaDTO> listaDentistaDTO2 = dentistaServiceImpl.buscarTodos();
        i = 1;
        for(DentistaDTO d : listaDentistaDTO2){
            if(!d.getNome().equals("Dentista Teste "+i++)){
                fail("Falha no teste de atualizacao");
            }
        }
    }

    @Test
    @Order(5)
    public void deletar() {
        for(DentistaDTO d : listaDentistaDTO){
            dentistaServiceImpl.deletar(d.getId());
        }
        List<DentistaDTO> listaDentistaDTO2 = dentistaServiceImpl.buscarTodos();
        if(dentistaServiceImpl.buscarTodos().size()>0 || usuarioServiceImpl.buscarTodos().size()>0){
            fail("Falha ao deletar todas entradas");
        }
    }
}