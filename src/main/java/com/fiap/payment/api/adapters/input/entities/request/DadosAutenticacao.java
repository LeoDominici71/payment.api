package com.fiap.payment.api.adapters.input.entities.request;


public class DadosAutenticacao{

    private String login;
    private String senha;

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
