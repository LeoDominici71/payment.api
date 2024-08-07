package com.fiap.payment.api.adapters.input.controllers;

import com.fiap.payment.api.adapters.input.entities.request.CartaoDTO;
import com.fiap.payment.api.adapters.input.entities.response.CartaoResponse;
import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.usecase.CartaoUseCase;
import com.fiap.payment.api.infra.utils.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cartao")
public class CartaoController {

    private final CartaoUseCase useCase;

    @Autowired
    public CartaoController(CartaoUseCase useCase){
        this.useCase = useCase;
    }
    @PostMapping
    public ResponseEntity<String> saveCartao(@RequestBody CartaoDTO request) throws Exception {
         useCase.CartaoUseCase(ClassMapper.toCartaoFromCartaoDTO(request));
         return ResponseEntity.ok(CartaoResponse.RESPOSTA);
    }

}
