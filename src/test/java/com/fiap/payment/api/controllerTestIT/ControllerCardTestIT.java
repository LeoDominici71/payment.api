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
import com.fiap.payment.api.adapters.input.entities.request.CartaoDTO;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.Usuario;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaCartaoRepository;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaClienteRepository;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.UsuarioRepository;
import com.fiap.payment.api.factory.Factory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControllerCardTestIT {

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

    @Autowired
    private JpaCartaoRepository cartaoRepository;

    @BeforeEach
    public void setup() {
        // Inserindo dados de teste no banco de dados
        repository.save(Factory.criarClienteEntity());
        Usuario user = new Usuario();
        user.setLogin("novoUsuario");
        user.setSenha("senhaSegura");
        userRepo.save(user);


    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveriaSalvarUmCartaoeRetornar201() throws Exception {
        // Arrange
        CartaoDTO request = Factory.criarCartaoDTO();
        String jsonBody = objectMapper.writeValueAsString(request);

        String token = factory.recuperarToken();


        // Act
        ResultActions response = mockMvc
                .perform(post("/api/cartao")
                        .header("Authorization", token)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isOk());

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveriaSalvarUmCartaoeRetornarGeneralExceptionCasoCPFSejaInexistente() throws Exception {
        // Arrange
        CartaoDTO request = Factory.criarCartaoInexistenteDTO();
        String jsonBody = objectMapper.writeValueAsString(request);

        String token = factory.recuperarToken();


        // Act
        ResultActions response = mockMvc
                .perform(post("/api/cartao")
                        .header("Authorization", token)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isUnprocessableEntity());

    }


    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveriaSalvarUmCartaoeRetornar403CasoClienteJaPossuaCartao() throws Exception {
        // Arrange
        cartaoRepository.save(Factory.criarCartaoEntity());
        CartaoDTO request = Factory.criarCartaoDTO();
        String jsonBody = objectMapper.writeValueAsString(request);

        String token = factory.recuperarToken();


        // Act
        ResultActions response = mockMvc
                .perform(post("/api/cartao")
                        .header("Authorization", token)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isForbidden());

    }
    
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveriaSalvarUmCartaoeRetornar400CasoCartaoSejaInvalido() throws Exception {
        // Arrange
        cartaoRepository.save(Factory.criarCartaoEntity());
        CartaoDTO request = Factory.criarCartaoDTOInvalido();
        String jsonBody = objectMapper.writeValueAsString(request);

        String token = factory.recuperarToken();


        // Act
        ResultActions response = mockMvc
                .perform(post("/api/cartao")
                        .header("Authorization", token)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isForbidden());

    }




}
