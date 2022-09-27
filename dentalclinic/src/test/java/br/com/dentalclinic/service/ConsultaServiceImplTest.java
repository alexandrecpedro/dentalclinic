package br.com.dentalclinic.service;

import br.com.dentalclinic.dto.*;
import br.com.dentalclinic.model.Consulta;
import br.com.dentalclinic.model.Dentista;
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
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Fail.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ConsultaServiceImplTest {
    /** Attributes **/

    @Autowired
    PacienteServiceImpl pacienteServiceImpl;

    @Autowired
    EnderecoServiceImpl enderecoServiceImpl;

    @Autowired
    TipoUsuarioServiceImpl tipoUsuarioServiceImpl;

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    DentistaServiceImpl dentistaService;

    @Autowired
    ClinicaServiceImpl clinicaService;

    @Autowired
    ConsultaServiceImpl consultaServiceImpl;

    static List<PacienteDTO> listaPacienteDTO = new ArrayList<>();
    static List<EnderecoDTO> listaEnderecoDTO = new ArrayList<>();
    static List<EnderecoDTO> listaEnderecoDTO2 = new ArrayList<>();
    static List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
    static List<TipoUsuarioDTO> listaTipoUsuarioDTO = new ArrayList<>();
    static List<DentistaDTO> listaDentistaDTO = new ArrayList<>();
    static List<ClinicaDTO> lsitaClinicasDTO = new ArrayList<>();
    static List<ConsultaDTO> listaConsultaDTO = new ArrayList<>();


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

        try {
            reader = new BufferedReader(new FileReader("./Enderecos.txt"));
            String line = reader.readLine();
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");
                EnderecoDTO end = new EnderecoDTO(atrArray[0],atrArray[1],atrArray[2],atrArray[3],atrArray[4],atrArray[5],atrArray[6]);
                listaEnderecoDTO2.add(enderecoServiceImpl.salvar(end));
                line = reader.readLine();
                BufferedReader.nullReader();
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
                ClinicaDTO clinicaDTO = new ClinicaDTO(atrArray[0],atrArray[1],listaEnderecoDTO2.get(i++));
                lsitaClinicasDTO.add(clinicaService.salvar(clinicaDTO));
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
                DentistaDTO dentistaDTO = new DentistaDTO(atrArray[0],atrArray[1],atrArray[2] ,listaUsuarioDTO.get(i) , lsitaClinicasDTO.get(i) );
                listaDentistaDTO.add(dentistaService.salvar(dentistaDTO));
                i++;
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            reader = new BufferedReader(new FileReader("./Consultas.txt"));
            String line = reader.readLine();
            int i = 0;
            while(line != null){
                String[] atrArray;
                atrArray = line.split(";");

                //banguela;pendente;2022;1;1;1;1
                //public Consulta(String descricao, String status, Paciente paciente, Dentista dentista, LocalDate data, LocalTime hora)

                ConsultaDTO consultaDTO = new ConsultaDTO(atrArray[1],atrArray[0],listaPacienteDTO.get(i), listaDentistaDTO.get(i),
                        LocalDate.of(Integer.parseInt(atrArray[2]), Integer.parseInt(atrArray[3]), Integer.parseInt(atrArray[4])),
                        LocalTime.of(Integer.parseInt((atrArray[5])),Integer.parseInt((atrArray[6]))));

                listaConsultaDTO.add(consultaServiceImpl.salvar(consultaDTO));
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
    public void buscarTodos() {
        List<ConsultaDTO> listaConsultaDTO2 = consultaServiceImpl.buscarTodos();
        if(listaConsultaDTO2.size()<listaConsultaDTO.size()){
            fail("Falha ao inserir ou buscar todas Consultas");
        }
    }

    @Test
    @Order(3)
    public void buscarById() {
        for(ConsultaDTO c1 : listaConsultaDTO){
            Optional<ConsultaDTO> c2 = consultaServiceImpl.buscarById(c1.getId());
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
    public void atualizar() {
        int i = 1;
        for(ConsultaDTO c : listaConsultaDTO){
            c.setStatus("consulta numero "+i++);
            consultaServiceImpl.atualizar(c);
        }
        List<ConsultaDTO> listaConsultaDTO2 = consultaServiceImpl.buscarTodos();
        i = 1;
        for(ConsultaDTO c2 : listaConsultaDTO2){
            if(!c2.getStatus().equals("consulta numero "+i++)){
                fail("Falha no teste de atualizacao");
            }
        }
    }

    @Test
    @Order(5)
    public void deletar() {
        for(ConsultaDTO c : listaConsultaDTO){
            consultaServiceImpl.deletar(c.getId());
        }
        if(consultaServiceImpl.buscarTodos().size()>0){
            fail("Falha ao deletar todas entradas");
        }
    }
}