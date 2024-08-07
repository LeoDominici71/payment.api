package com.fiap.payment.api.adapters.input.entities.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;


@Setter
public class PagamentoListDTO {

    private Double valor;
    private String descricao;
    @JsonProperty("metodo_pagamento")
    private String metodoPagamento;
    private String status;

}
