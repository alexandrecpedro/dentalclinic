package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.*;
import br.com.dentalclinic.service.impl.EnderecoServiceImpl;
import br.com.dentalclinic.service.impl.PacienteServiceImpl;
import br.com.dentalclinic.service.impl.TipoUsuarioServiceImpl;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
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
import java.util.List;
import java.util.Optional;

import static br.com.dentalclinic.service.UsuarioServiceImplTest.listaTipoUsuario;
import static org.assertj.core.api.Fail.fail;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PacienteServiceImplTest {
    /** Attributes **/
    @Autowired
    PacienteServiceImpl pacienteServiceImpl;

    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    @Autowired
    TipoUsuarioServiceImpl tipoUsuarioServiceImpl;

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;



    static List<PacienteDTO> listaPacienteDTO = new ArrayList<>();
    static List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();
    static List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
    static List<TipoUsuarioDTO> listaTipoUsuarioDTO = new ArrayList<>();


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
        try {
            reader = new BufferedReader(new FileReader("./Enderecos.txt"));
            String line = reader.readLine();
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                EnderecoDTO end = new EnderecoDTO(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
                listaEnderecoDTO.add(enderecoServiceImpl.salvar(end));
                line = reader.readLine();
                BufferedReader.nullReader();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        try{
            reader = new BufferedReader(new FileReader("./Pacientes.txt"));
            String line = reader.readLine();
            int i=1;
            while(line!=null){
                String[] arrayLineSplit = line.split(";");

                //PacienteDTO(String nome, String sobrenome, String cpf, String telefone, Usuario usuario, Endereco endereco)
                listaPacienteDTO.add(new PacienteDTO(arrayLineSplit[0],arrayLineSplit[1],arrayLineSplit[2],arrayLineSplit[3],usuarioServiceImpl.buscarById(i).get(),enderecoServiceImpl.buscarById(i).get()));
                i++;
                line = reader.readLine();
            }
            for(i = 0;i<listaPacienteDTO.size();i++){
                listaPacienteDTO.set(i,pacienteServiceImpl.salvar(listaPacienteDTO.get(i)));
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Test
    @Order(2)
    public void buscarTodos(){
        List<PacienteDTO> todasClinicasDb = pacienteServiceImpl.buscarTodos();
        if(todasClinicasDb.size()<listaPacienteDTO.size()){
            fail("Falha ao inserir ou buscar todos pacientes");
        }
    }

    @Test
    @Order(3)
    public void buscarById() {

        for(PacienteDTO p1 : listaPacienteDTO){
            Optional<PacienteDTO> p2 = pacienteServiceImpl.buscarById(p1.getId());
            if(p2.isEmpty()){
                fail("Falha buiscando Paciente na BD.");
            }
            if(!comparaObjetoToString(p1, p2.get())){
                fail("Falha buiscando Paciente na BD.");
            }
        }

    }

    @Test
    @Order(4)
    public void atualizar() {

        int i = 1;
        for(PacienteDTO p : listaPacienteDTO){
            p.setNome("Nome Teste "+i++);
            pacienteServiceImpl.atualizar(p);
        }
        List<PacienteDTO> listaPacienteDTO2 = pacienteServiceImpl.buscarTodos();
        i = 1;
        for(PacienteDTO p : listaPacienteDTO2){
            if(!p.getNome().equals("Nome Teste "+i++)){
                fail("Falha no teste de atualizacao");
            }
        }

    }

    @Test
    @Order(5)
    public void deletar() {
        for(PacienteDTO p : listaPacienteDTO){
            pacienteServiceImpl.deletar(p.getId());
        }
        if(pacienteServiceImpl.buscarTodos().size()>0 || enderecoServiceImpl.buscarTodos().size()>0 || usuarioServiceImpl.buscarTodos().size()>0){
            fail("Falha ao deletar todas entradas");
        }
    }
}