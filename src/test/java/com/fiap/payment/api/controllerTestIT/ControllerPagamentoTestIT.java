package com.fiap.payment.api.controllerTestIT;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
import com.fiap.payment.api.adapters.input.entities.request.PagamentoDTO;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.Usuario;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaCartaoRepository;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaClienteRepository;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.UsuarioRepository;
import com.fiap.payment.api.factory.Factory;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControllerPagamentoTestIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private JpaClienteRepository repository;

    @Autowired
    private JpaCartaoRepository cartaoRepository;

    @Autowired
    private UsuarioRepository userRepo;

    @Autowired
    private Factory factory;

    @BeforeEach
    public void setup() {
        // Inserindo dados de teste no banco de dados
        Usuario user = new Usuario();
        user.setLogin("novoUsuario");
        user.setSenha("senhaSegura");
        userRepo.save(user);

        repository.save(Factory.criarClienteEntity());
        cartaoRepository.save(Factory.criarCartaoEntity());



    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveriaSalvarUmPagamentoeRetornar201() throws Exception {
        // Arrange
        PagamentoDTO request = Factory.criarPagamentoDTO();
        String jsonBody = objectMapper.writeValueAsString(request);

        String token = factory.recuperarToken();


        // Act
        ResultActions response = mockMvc
                .perform(post("/api/pagamento")
                        .header("Authorization", token)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isOk());

    }
    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void deveBuscarUmPagamentoPorChave() throws Exception {

        String token = factory.recuperarToken();


        // Act
        ResultActions result = mockMvc
                .perform(get("/api/pagamento/cliente/{cpf}", "48374255854")
                        .header("Authorization", token)
                        .accept(MediaType.APPLICATION_JSON));

        // Assert
        result.andExpect(status().isOk());

    }

    @Test
    @DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
    public void NaoDeveriaSalvarUmPagamentoComLimiteMaior() throws Exception {
        // Arrange
        PagamentoDTO request = Factory.criarPagamentoComLimiteMaiorDTO();
        String jsonBody = objectMapper.writeValueAsString(request);

        String token = factory.recuperarToken();


        // Act
        ResultActions response = mockMvc
                .perform(post("/api/pagamento")
                        .header("Authorization", token)
                        .content(jsonBody).contentType(MediaType.APPLICATION_JSON));

        // Assert
        response.andExpect(status().isPaymentRequired());

    }






}
