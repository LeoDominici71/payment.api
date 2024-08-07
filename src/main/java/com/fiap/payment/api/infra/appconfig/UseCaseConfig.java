package com.fiap.payment.api.infra.appconfig;

import com.fiap.payment.api.domain.repositories.CartaoRepository;
import com.fiap.payment.api.domain.repositories.ClientRepository;
import com.fiap.payment.api.domain.repositories.PagamentoRepository;
import com.fiap.payment.api.domain.usecase.CartaoUseCase;
import com.fiap.payment.api.domain.usecase.ClientUseCase;
import com.fiap.payment.api.domain.usecase.PagamentoUseCase;
import com.fiap.payment.api.domain.usecase.ValidaCartao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UseCaseConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ValidaCartao validaCartao(){
        return new ValidaCartao();
    }

    @Bean
    public ClientUseCase clientUseCase(ClientRepository repository){
        return new ClientUseCase(repository);
    }

    @Bean
    public CartaoUseCase cartaoUseCase(CartaoRepository repository, ClientRepository clientRepository){
        return new CartaoUseCase(repository, clientRepository);
    }

    @Bean
    public PagamentoUseCase pagamentoUseCase(PagamentoRepository repository, CartaoRepository cartaoRepository, ClientRepository clientRepository, ValidaCartao validaCartao){
        return new PagamentoUseCase(repository, cartaoRepository, clientRepository, validaCartao);
    }


}
