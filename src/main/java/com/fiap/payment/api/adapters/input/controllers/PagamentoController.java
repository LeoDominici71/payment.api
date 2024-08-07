package com.fiap.payment.api.adapters.input.controllers;

import com.fiap.payment.api.adapters.input.entities.request.PagamentoDTO;
import com.fiap.payment.api.adapters.input.entities.response.PagamentoListDTO;
import com.fiap.payment.api.adapters.input.entities.response.PagamentoResponse;
import com.fiap.payment.api.domain.entities.Pagamento;
import com.fiap.payment.api.domain.usecase.PagamentoUseCase;
import com.fiap.payment.api.infra.utils.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pagamento")
public class PagamentoController {

    public final PagamentoUseCase useCase;

    @Autowired
    public PagamentoController(PagamentoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping
    public ResponseEntity<PagamentoResponse> registraPagamento(@RequestBody PagamentoDTO pagamentoDTO) {
        Pagamento pagamento = useCase.registrarPagamento(ClassMapper.toPagamentoFromDTO(pagamentoDTO));
        return ResponseEntity.ok(new PagamentoResponse(pagamento));
    }

    @GetMapping("/cliente/{cpf}")
    public ResponseEntity<List<PagamentoListDTO>> buscarListaDePagamento(@PathVariable String cpf) {
        return ResponseEntity.ok(useCase.buscarListaDePagamentos(cpf).stream().map(ClassMapper::toPagamentoList).collect(Collectors.toList()));
    }


}
