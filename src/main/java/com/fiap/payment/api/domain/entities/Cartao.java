package com.fiap.payment.api.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Cartao {

    private String cpf;
    private String limite;
    private String numero;
    private String dataValidade;
    private String cvv;

    public Cartao(){

    }

    public String getCpf() {
        return cpf;
    }

    public String getLimite() {
        return limite;
    }

    public String getNumero() {
        return numero;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
}
