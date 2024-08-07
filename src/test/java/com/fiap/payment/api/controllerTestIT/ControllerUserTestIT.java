package com.fiap.payment.api.controllerTestIT;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.payment.api.adapters.input.entities.request.UserDTO;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.Usuario;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaClienteRepository;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.UsuarioRepository;
import com.fiap.payment.api.factory.Factory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControllerUserTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JpaClienteRepository repository;

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private Factory factory;


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveriaSalvarUmClienteRetornar201() throws Exception {
        // Arrange
        UserDTO request = Factory.criarUserDTO();
        String jsonBody = objectMapper.writeValueAsString(request);



        // Act
        ResultActions response = mockMvc
                .perform(post("/api/register")
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isCreated());

    }




}
