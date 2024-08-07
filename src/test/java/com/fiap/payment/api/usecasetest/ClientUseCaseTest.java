package com.fiap.payment.api.usecasetest;

import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.repositories.CartaoRepository;
import com.fiap.payment.api.domain.repositories.ClientRepository;
import com.fiap.payment.api.domain.usecase.CartaoUseCase;
import com.fiap.payment.api.domain.usecase.ClientUseCase;
import com.fiap.payment.api.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ClientUseCaseTest {

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientUseCase service;

    @Test
    public void deveRegistrarUmCliente() throws Exception {
        //Arrange
        Cliente cliente = Factory.criarCliente();

        Mockito.when(clientRepository.saveClient(cliente)).thenReturn(cliente);

        //Act
        Cliente clienteSalvo = service.saveCliente(cliente);

        //Assert
        Assertions.assertNotNull(clienteSalvo);


    }
}
