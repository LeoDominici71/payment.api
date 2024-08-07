package com.fiap.payment.api.domain.usecase;

import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Pagamento;
import com.fiap.payment.api.infra.exceptions.GeneralClientSystemException;

import java.util.UUID;
import java.util.function.Predicate;

public class ValidaCartao {

    public String validaCartao(Cartao cartao, Pagamento pagamento) {
        Predicate<Pagamento> isValid = payment -> payment.getCvv().equals(cartao.getCvv()) && payment.getNumero().equals(pagamento.getNumero());
        if (isValid.equals(false)) {
            throw new GeneralClientSystemException("Card invalid");
        }

        // Gera um UUID aleatório
        UUID uuid = UUID.randomUUID();
        // Converte o UUID para uma string sem os hífens
        String uniqueCode = uuid.toString().replace("-", "").toUpperCase();
        return uniqueCode;
    }

}
