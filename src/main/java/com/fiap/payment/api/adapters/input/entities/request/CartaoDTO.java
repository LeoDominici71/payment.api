package com.fiap.payment.api.adapters.input.entities.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.CartaoEntity;
import com.fiap.payment.api.domain.entities.Cartao;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
public class CartaoDTO {

    @NotNull
    @CPF
    private String cpf;
    private String limite;
    private String numero;
    @JsonProperty("data_validade")
    private String dataValidade;
    private String cvv;



}
