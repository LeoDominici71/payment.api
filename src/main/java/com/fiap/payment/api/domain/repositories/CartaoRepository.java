package com.fiap.payment.api.domain.repositories;

import com.fiap.payment.api.domain.entities.Cartao;

public interface CartaoRepository {

    Cartao saveCartao(Cartao cartao);

    Cartao findByCpf(String cpf);

    Cartao updateCardLimit(Double valor, String cpf);
}
