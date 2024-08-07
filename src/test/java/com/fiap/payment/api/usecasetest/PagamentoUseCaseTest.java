package com.fiap.payment.api.usecasetest;

import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.entities.Pagamento;
import com.fiap.payment.api.domain.repositories.CartaoRepository;
import com.fiap.payment.api.domain.repositories.ClientRepository;
import com.fiap.payment.api.domain.repositories.PagamentoRepository;
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
public class PagamentoUseCaseTest {


    @Mock
    private PagamentoRepository repository;

    @Mock
    private CartaoRepository cartaoRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ValidaCartao validaCartao;

    @InjectMocks
    private PagamentoUseCase service;

    @Test
    public void deveRegistrarUmPagamento() {
        //Arrange
        Pagamento pagamento = Factory.criarPagamento();
        Cartao cartao = Factory.criarCartao();
        Cliente cliente = Factory.criarCliente();



        Mockito.when(repository.registrarPagamento(pagamento)).thenReturn(pagamento);
        Mockito.when(cartaoRepository.findByCpf(pagamento.getCpf())).thenReturn(cartao);
        Mockito.when(validaCartao.validaCartao(cartao, pagamento)).thenReturn("624D442A5D764A10A9C51E0E94313589");
        Mockito.when(clientRepository.findByCpf(pagamento.getCpf())).thenReturn(cliente);

        //Act
        Pagamento pagamentoSalvo = service.registrarPagamento(pagamento);

        //Assert
        Assertions.assertNotNull(pagamentoSalvo);


    }

    @Test
    public void deveRetornarUmaListaDePagamentos(){

        Pagamento pagamento = Factory.criarPagamento();

        List<Pagamento> lista = new ArrayList<>();

        lista.add(pagamento);

        Mockito.when(repository.listaDePagamenntos(pagamento.getCpf())).thenReturn(lista);

        //Act
        List<Pagamento> pagamentoSalvo = service.buscarListaDePagamentos(pagamento.getCpf());

        //Assert
        Assertions.assertNotNull(pagamentoSalvo);



    }




}
