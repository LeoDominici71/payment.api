package com.fiap.payment.api.domain.usecase;

import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.repositories.ClientRepository;

public class ClientUseCase {

    private final ClientRepository repository;

    public ClientUseCase(ClientRepository repository){
        this.repository = repository;
    }

    public Cliente saveCliente(Cliente cliente){
        return repository.saveClient(cliente);
    }

    public Cliente findByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

}
