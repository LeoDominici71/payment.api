package com.fiap.payment.api.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fiap.payment.api.adapters.input.entities.request.*;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.CartaoEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.ClienteEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.Usuario;
import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.entities.Pagamento;
import com.fiap.payment.api.infra.authconfig.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.client.RestTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@Component
public class Factory {

    @Autowired
    private TokenService service;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RestTemplate restTemplate;

    public static ClienteEntity criarClienteEntity(){
        ClienteEntity cliente = new ClienteEntity();
        cliente.setNome("teste");
        cliente.setRua("teste");
        cliente.setTelefone("13998898989");
        cliente.setCidade("teste");
        cliente.setPais("testao");
        cliente.setCep("11701111");
        cliente.setEstado("ts");
        cliente.setEmail("teste@teste.com");
        cliente.setCpf("48374255854");

        return cliente;

    }


    public static ClienteDTO criarClienteDTO(){
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNome("teste");
        cliente.setRua("teste");
        cliente.setTelefone("13998898989");
        cliente.setCidade("teste");
        cliente.setPais("testao");
        cliente.setCep("11701111");
        cliente.setEstado("ts");
        cliente.setEmail("teste@teste.com");
        cliente.setCpf("48374255854");

        return cliente;

    }
    
    public static UserDTO criarUserDTO(){
        UserDTO user = new UserDTO();
        user.setLogin("User");        
        user.setSenha("senha");

        return user;

    }

    public static Cliente criarCliente(){
        Cliente cliente = new Cliente();
        cliente.setNome("teste");
        cliente.setRua("teste");
        cliente.setTelefone("13998898989");
        cliente.setCidade("teste");
        cliente.setPais("testao");
        cliente.setCep("11701111");
        cliente.setEstado("ts");
        cliente.setEmail("teste@teste.com");
        cliente.setCpf("48374255854");

        return cliente;

    }

    public static ClienteDTO criarClienteDTOBadRequest(){
        ClienteDTO cliente = new ClienteDTO();
        cliente.setNome("teste");
        cliente.setRua("teste");
        cliente.setTelefone("13998898989");
        cliente.setCidade("teste");
        cliente.setPais("testao");
        cliente.setCep("11701111");
        cliente.setEstado("ts");
        cliente.setEmail("teste@teste.com");
        cliente.setCpf("4835");

        return cliente;

    }

    public static PagamentoDTO criarPagamentoDTO(){
        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setCpf("48374255854");
        pagamento.setDataValidade("11/01/2026");
        pagamento.setCvv("123");
        pagamento.setNumero("123445667888");
        pagamento.setValor(500.00);

        return pagamento;

    }

    public static Pagamento criarPagamento(){
        Pagamento pagamento = new Pagamento();
        pagamento.setCpf("48374255854");
        pagamento.setDataValidade("11/01/2026");
        pagamento.setCvv("123");
        pagamento.setNumero("123445667888");
        pagamento.setValor(500.00);

        return pagamento;

    }

    public static PagamentoDTO criarPagamentoComCPFErradoDTO(){
        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setCpf("483742");
        pagamento.setDataValidade("11/01/2026");
        pagamento.setCvv("123");
        pagamento.setNumero("123445667888");
        pagamento.setValor(500.00);

        return pagamento;

    }

    public static PagamentoDTO criarPagamentoComLimiteMaiorDTO(){
        PagamentoDTO pagamento = new PagamentoDTO();
        pagamento.setCpf("48374255854");
        pagamento.setDataValidade("11/01/2026");
        pagamento.setCvv("123");
        pagamento.setNumero("123445667888");
        pagamento.setValor(50000.00);

        return pagamento;

    }

    public static CartaoDTO criarCartaoDTO(){
        CartaoDTO cartao = new CartaoDTO();
        cartao.setDataValidade("11/01/2026");
        cartao.setCvv("123");
        cartao.setNumero("123445667888");
        cartao.setLimite("5000");
        cartao.setCpf("48374255854");

        return cartao;

    }
    
    public static CartaoDTO criarCartaoDTOInvalido(){
        CartaoDTO cartao = new CartaoDTO();
        cartao.setDataValidade("11/01/2030");
        cartao.setCvv("1235656");
        cartao.setNumero("1234456678886565656");
        cartao.setLimite("5000");
        cartao.setCpf("48374255854");

        return cartao;

    }

    public static Cartao criarCartao(){
        Cartao cartao = new Cartao();
        cartao.setDataValidade("11/01/2026");
        cartao.setCvv("123");
        cartao.setNumero("123445667888");
        cartao.setLimite("5000");
        cartao.setCpf("48374255854");

        return cartao;

    }

    public static CartaoDTO criarCartaoInexistenteDTO(){
        CartaoDTO cartao = new CartaoDTO();
        cartao.setDataValidade("11/01/2026");
        cartao.setCvv("123");
        cartao.setNumero("123445667888");
        cartao.setLimite("5000");
        cartao.setCpf("48374");

        return cartao;

    }

    public static CartaoEntity criarCartaoEntity(){
        CartaoEntity cartao = new CartaoEntity();
        cartao.setDataValidade("11/01/2026");
        cartao.setCvv("123");
        cartao.setNumero("123445667888");
        cartao.setLimite("5000");
        cartao.setCpf("48374255854");

        return cartao;

    }

    public String recuperarToken() throws Exception {

        Usuario request = new Usuario();
        request.setLogin("novoUsuario");
        request.setSenha("senhaSegura");

        return service.generateToken(request);


    }
}
