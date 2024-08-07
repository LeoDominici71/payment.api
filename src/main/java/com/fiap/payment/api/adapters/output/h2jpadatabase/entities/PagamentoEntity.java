package com.fiap.payment.api.adapters.output.h2jpadatabase.entities;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fiap.payment.api.domain.entities.Pagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String numero;
    private String dataValidade;
    private String cvv;
    private Double valor;
    private String chavePagamento;
    private Long clientId;

    public PagamentoEntity(Pagamento pagamento){
        setCpf(pagamento.getCpf());
        setNumero(pagamento.getNumero());
        setDataValidade(pagamento.getDataValidade());
        setCvv(pagamento.getCvv());
        setValor(pagamento.getValor());
        setChavePagamento(pagamento.getChavePagamento());
        setClientId(pagamento.getClientId());
    }

}
