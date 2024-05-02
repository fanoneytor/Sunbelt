package com.microservicio.sunbelt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ClienteServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testDatosDeEntradaCorrectos() throws Exception {
        String requestBody = "{\"tipoDocumento\": \"C\", \"numeroDocumento\": \"10121314\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/cliente/consultarCliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.primerNombre").value("Carlos"));
    }

    @Test
    public void testDocumentoNoEncontrado() throws Exception {
        String requestBody = "{\"tipoDocumento\": \"C\", \"numeroDocumento\": \"1234567\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/cliente/consultarCliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andExpect(status().isNotFound());
    }
}