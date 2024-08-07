package com.fiap.payment.api.adapters.input.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class PagamentoDTO {

    @NotNull
    @CPF
    private String cpf;
    private String numero;
    @JsonProperty("data_validade")
    private String dataValidade;
    private String cvv;
    private Double valor;
    @JsonProperty("chave_pagamento")
    private String chavePagamento;

}
