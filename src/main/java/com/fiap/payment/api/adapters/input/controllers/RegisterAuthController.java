package com.fiap.payment.api.adapters.input.controllers;

import com.fiap.payment.api.adapters.input.entities.request.UserDTO;
import com.fiap.payment.api.infra.authconfig.AutenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api/register")
public class RegisterAuthController {

    @Autowired
    private AutenticationService service;

    @PostMapping
    public ResponseEntity<UserDTO> registro(@RequestBody @Valid UserDTO user) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(service.saveUser(user));
    }

}