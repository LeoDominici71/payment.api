package com.fiap.payment.api.adapters.input.controllers;

import com.fiap.payment.api.adapters.input.entities.request.ClienteDTO;
import com.fiap.payment.api.adapters.input.entities.response.ClientDTOReturn;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.usecase.ClientUseCase;
import com.fiap.payment.api.infra.utils.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private ClientUseCase useCase;

    @PostMapping
    public ResponseEntity<ClientDTOReturn> saveClient(@RequestBody ClienteDTO dto) {
        Cliente client = useCase.saveCliente(ClassMapper.toClienteFromDTO(dto));
        return ResponseEntity.ok(new ClientDTOReturn(client));
    }


}
