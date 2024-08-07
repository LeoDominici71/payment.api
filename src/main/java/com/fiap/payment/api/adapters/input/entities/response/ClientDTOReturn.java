package com.fiap.payment.api.adapters.input.entities.response;

import com.fiap.payment.api.domain.entities.Cliente;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientDTOReturn {

    private Long id;

    public ClientDTOReturn(Cliente cliente){
        setId(cliente.getId());
    }
}
