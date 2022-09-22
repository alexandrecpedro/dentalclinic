package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
import br.com.dentalclinic.model.*;
import br.com.dentalclinic.service.impl.*;
import org.junit.jupiter.api.Test;
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

    /** Tests **/
    /*
    @Test
    public void PopulandoTabelasAuxiliares(){
        BufferedReader reader;
        //##########################################################
        //loop para popular Tabela TipoUsuario
        //##########################################################
        try{
            reader = new BufferedReader(new FileReader("./TipoUsuarios.txt"));
            String line = reader.readLine();
            while(line!=null){
                tipoUsuarioServiceImpl.salvar(new TipoUsuario(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("Falha Inserindo TipoUsuario");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Falha Inserindo TipoUsuario");
        }

        //##########################################################
        //loop para popular Tabela Usuario
        //##########################################################

        try{
            reader = new BufferedReader(new FileReader("./Usuario.txt"));
            String line = reader.readLine();
            while(line!=null){
                String[] arrayLineSplit = line.split(";");
                usuarioServiceImpl.salvar(new Usuario(arrayLineSplit[0],arrayLineSplit[1],tipoUsuarioServiceImpl.buscarByNome(arrayLineSplit[2])));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("Falha Inserindo Usuarios");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Falha Inserindo Usuarios");
        }
        //##########################################################
        //loop para popular Tabela Endereco
        //##########################################################
        try {
            reader = new BufferedReader(new FileReader("./Enderecos.txt"));
            String line = reader.readLine();
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                Endereco end = new Endereco(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
                enderecoServiceImplTest.salvar(end);
                line = reader.readLine();

            }
            BufferedReader.nullReader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("Falha Inserindo Enderecos");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Falha Inserindo Enderecos");
        }

        //##########################################################
        //loop para popular Tabela Clinica
        //##########################################################
        try {
            reader = new BufferedReader(new FileReader("./Clinicas.txt"));
            String line = reader.readLine();
            String[] atrArray;
            for(Endereco e : enderecoServiceImplTest.buscarTodos()){
                atrArray = line.split(";");
                Clinica clinica = new Clinica(atrArray[0],atrArray[1],e);
                line = reader.readLine();
            }
            BufferedReader.nullReader();
        } catch (FileNotFoundException e) {
            fail("Falha Inserindo Clinicas");
            e.printStackTrace();
        } catch (IOException e) {
            fail("Falha Inserindo Clinicas");
            e.printStackTrace();
        }
    }*/
    @Test
    public void salvar() {
        BufferedReader reader;

        //##########################################################
        //loop para popular Tabela TipoUsuario
        //##########################################################
        try{
            reader = new BufferedReader(new FileReader("./TipoUsuarios.txt"));
            String line = reader.readLine();
            while(line!=null){
                tipoUsuarioServiceImpl.salvar(new TipoUsuarioDTO(line));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("Falha Inserindo TipoUsuario");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Falha Inserindo TipoUsuario");
        }

        //##########################################################
        //loop para popular Tabela Usuario
        //##########################################################

        try{
            reader = new BufferedReader(new FileReader("./Usuario.txt"));
            String line = reader.readLine();
            while(line!=null){
                String[] arrayLineSplit = line.split(";");
                usuarioServiceImpl.salvar(new UsuarioDTO(arrayLineSplit[0],arrayLineSplit[1],tipoUsuarioServiceImpl.buscarByNome(arrayLineSplit[2])));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            fail("Falha Inserindo Usuarios");
        } catch (IOException e) {
            e.printStackTrace();
            fail("Falha Inserindo Usuarios");
        }
        //##########################################################
        //loop para popular Tabela Endereco
        //##########################################################
        try {
            reader = new BufferedReader(new FileReader("./Enderecos.txt"));
            String line = reader.readLine();
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                //Endereco end = new Endereco(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
                enderecoServiceImpl.salvar(new EnderecoDTO(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            fail("Falha Inserindo Enderecos");
            e.printStackTrace();
        } catch (IOException e) {
            fail("Falha Inserindo Enderecos");
            e.printStackTrace();
        }

        //##########################################################
        //loop para popular Tabela Clinica
        //##########################################################
        try {
            reader = new BufferedReader(new FileReader("./Clinicas.txt"));
            String line = reader.readLine();
            String[] atrArray;
            List<EnderecoDTO> listaEnderecos = enderecoServiceImpl.buscarTodos();
            for(EnderecoDTO e : listaEnderecos){
                atrArray = line.split(";");
                clinicaServiceImpl.salvar(new ClinicaDTO(atrArray[0],atrArray[1],enderecoServiceImpl.buscarById(e.getId()).get()));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            //fail("Falha Inserindo Clinicas FileNotFoundException");
            e.printStackTrace();
        } catch (IOException e) {
            //fail("Falha Inserindo Clinicas IOException");
            e.printStackTrace();
        }catch (Exception e){
            //fail("Falha Inserindo Clinicas");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        //for(Clinica c : clinicaServiceImpl.buscarTodos()){
        //    System.out.println(c.toString());
        //}

        try {
            reader = new BufferedReader(new FileReader("./Dentistas.txt"));
            String line = reader.readLine();
            String[] atrArray;
            while(line!=null){
                atrArray = line.split(";");
                Optional<Usuario> usuario = usuarioServiceImpl.buscarByEmail(atrArray[3]);
                System.out.println(atrArray[3] + " - " + usuario.isEmpty());
                Optional<Clinica> clinica = clinicaServiceImpl.buscarByNomeFantasia(atrArray[4]);
                System.out.println(atrArray[4] + " - " + clinica.isEmpty());
                if(usuario.isEmpty() || clinica.isEmpty()){
                    fail("Falha Salvando Dentistas.");
                }
                else{
                    dentistaServiceImpl.salvar(new Dentista(atrArray[0],atrArray[1],atrArray[2],usuario.get(),clinica.get()));
                }
                line = reader.readLine();
            }
            BufferedReader.nullReader();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void buscarById() {}

    @Test
    public void atualizar() {}

    @Test
    public void deletar() {}
}