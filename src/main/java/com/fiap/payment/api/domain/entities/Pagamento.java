package com.fiap.payment.api.domain.entities;

public class Pagamento {

    private String cpf;
    private String numero;
    private String dataValidade;
    private String cvv;
    private Double valor;
    private String chavePagamento;
    private Long clientId;

    public Pagamento() {

    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getChavePagamento() {
        return chavePagamento;
    }

    public String getCpf() {
        return cpf;
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

    public Double getValor() {
        return valor;
    }

    public void setChavePagamento(String chavePagamento) {
        this.chavePagamento = chavePagamento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
