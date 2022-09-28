package br.com.dentalclinic.controller;

import br.com.dentalclinic.dto.ClinicaDTO;
import br.com.dentalclinic.dto.EnderecoDTO;
import br.com.dentalclinic.dto.TipoUsuarioDTO;
import br.com.dentalclinic.dto.UsuarioDTO;
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

import static br.com.dentalclinic.utils.DentalClinicUtils.asJsonString;
import static br.com.dentalclinic.utils.DentalClinicUtils.objectFromString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@SpringBootTest
@AutoConfigureMockMvc
class ClinicaControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    void salvarTest() throws Exception {
        EnderecoDTO enderecoDTO = new EnderecoDTO("Rua Germano Vítor dos Santos","598","CASA 013","Morumbi","LOCALIDADE 1","SP","00000-001"
);
        ClinicaDTO clinicaDTO = new ClinicaDTO("Clinica Alex das antiga","alex&cia",enderecoDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/clinica/salvar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(asJsonString(clinicaDTO)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();
        clinicaDTO = objectFromString(ClinicaDTO.class, responseBody);
        assertNotNull(clinicaDTO.getId());
    }

}