package com.fiap.payment.api.adapters.output.h2jpadatabase.repository.impl;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.ClienteEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaClienteRepository;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.repositories.ClientRepository;
import com.fiap.payment.api.infra.utils.ClassMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class ClientRepositoryImpl implements ClientRepository {

    @Autowired
    private JpaClienteRepository repository;

    @Override
    public Cliente saveClient(Cliente cliente) {
        return ClassMapper.toCliente(repository.save(new ClienteEntity(cliente)));
    }

    @Override
    public Cliente findByCpf(String cpf) {
        try {
            Optional<ClienteEntity> clienteEntityOptional = repository.findByCpf(cpf);
            ClienteEntity clienteEntity = clienteEntityOptional.orElseThrow(() -> new EntityNotFoundException("Not found"));
            return ClassMapper.toCliente(clienteEntity);
        }catch(Exception e){
            ClientRepositoryImpl.log.info("Cartão nao encontrado");
            return null;
        }
    }
}
