package com.fiap.payment.api.usecasetest;

import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.entities.Pagamento;
import com.fiap.payment.api.domain.repositories.CartaoRepository;
import com.fiap.payment.api.domain.repositories.ClientRepository;
import com.fiap.payment.api.domain.repositories.PagamentoRepository;
import com.fiap.payment.api.domain.usecase.CartaoUseCase;
import com.fiap.payment.api.domain.usecase.PagamentoUseCase;
import com.fiap.payment.api.domain.usecase.ValidaCartao;
import com.fiap.payment.api.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CartaoUseCaseTest {


    @Mock
    private CartaoRepository cartaoRepository;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private CartaoUseCase service;

    @Test
    public void deveRegistrarUmCartao() throws Exception {
        //Arrange
        Cartao cartao = Factory.criarCartao();
        Cliente cliente = Factory.criarCliente();



        Mockito.when(cartaoRepository.findByCpf(cartao.getCpf())).thenReturn(null);
        Mockito.when(clientRepository.findByCpf(cartao.getCpf())).thenReturn(cliente);
        Mockito.when(cartaoRepository.saveCartao(cartao)).thenReturn(cartao);

        //Act
        Cartao cartaoSalvo = service.CartaoUseCase(cartao);

        //Assert
        Assertions.assertNotNull(cartaoSalvo);


    }
}
