package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.*;
import br.com.dentalclinic.model.Paciente;
import br.com.dentalclinic.service.impl.ClinicaServiceImpl;
import br.com.dentalclinic.service.impl.DentistaServiceImpl;
import br.com.dentalclinic.service.impl.PacienteServiceImpl;
import br.com.dentalclinic.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static br.com.dentalclinic.utils.DentalClinicUtils.asJsonString;
import static br.com.dentalclinic.utils.DentalClinicUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
class ConsultaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @Autowired
    private DentistaServiceImpl dentistaService;

    @Autowired
    private PacienteServiceImpl pacienteService;

    @Autowired
    private ClinicaServiceImpl clinicaService;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void salvarTest() throws Exception {
        TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO("ROLE_ADMIN");
        UsuarioDTO usuarioDTO = new UsuarioDTO("user","user",tipoUsuarioDTO);
        usuarioDTO = usuarioService.salvar(usuarioDTO);
        EnderecoDTO enderecoDTO = new EnderecoDTO("Rua Germano Vítor dos Santos","598","CASA 013","Morumbi","LOCALIDADE 1","SP","00000-001"
        );
        ClinicaDTO clinicaDTO = new ClinicaDTO("Clinica Alex das antiga","alex&cia",enderecoDTO);
        clinicaDTO = clinicaService.salvar(clinicaDTO);
        PacienteDTO pacienteDTO = new PacienteDTO("filipe","abreu","123456789","565656565",usuarioDTO,enderecoDTO);
        pacienteDTO = pacienteService.salvar(pacienteDTO);
        DentistaDTO dentistaDTO = new DentistaDTO("Joao","Abilio","1258455",usuarioDTO,clinicaDTO);
        dentistaDTO = dentistaService.salvar(dentistaDTO);
        ConsultaDTO consultaDTO = new ConsultaDTO("des","confirmada",pacienteDTO,dentistaDTO,"30/05/2022" , "10:30");

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/consulta/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(consultaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        consultaDTO = objectFromString(ConsultaDTO.class, responseBody);
        assertNotNull(consultaDTO.getId());
    }
}