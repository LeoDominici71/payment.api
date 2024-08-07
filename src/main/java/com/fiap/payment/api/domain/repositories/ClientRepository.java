package com.fiap.payment.api.domain.repositories;

import com.fiap.payment.api.domain.entities.Cliente;

public interface ClientRepository {

    Cliente saveClient(Cliente cliente);

    Cliente findByCpf(String cpf);

}
