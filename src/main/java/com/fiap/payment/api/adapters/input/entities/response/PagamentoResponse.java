package com.fiap.payment.api.adapters.input.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.payment.api.domain.entities.Pagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoResponse {

    @JsonProperty("chave_pagamento")
    private String chavePagamento;
    private Long clientId;


    public PagamentoResponse(Pagamento pagamento){
        setChavePagamento(pagamento.getChavePagamento());
        setClientId(pagamento.getClientId());
    }
}
