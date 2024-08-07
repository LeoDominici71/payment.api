package com.fiap.payment.api.domain.usecase;

import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.repositories.CartaoRepository;
import com.fiap.payment.api.domain.repositories.ClientRepository;
import com.fiap.payment.api.infra.exceptions.GeneralClientSystemException;
import com.fiap.payment.api.infra.exceptions.MaxNumberOfCardException;

public class CartaoUseCase {

    private final CartaoRepository repository;

    private final ClientRepository clientRepository;

    public CartaoUseCase(CartaoRepository repository, ClientRepository clientRepository) {
        this.repository = repository;
        this.clientRepository = clientRepository;
    }

    public Cartao CartaoUseCase(Cartao cartao) throws Exception {
        if (repository.findByCpf(cartao.getCpf()) != null) {
            throw new MaxNumberOfCardException("Cliente já possui cartão");
        }
        if (clientRepository.findByCpf(cartao.getCpf()) == null) {
            throw new GeneralClientSystemException("Cliente não existe");
        }
        return repository.saveCartao(cartao);
    }

    public Cartao updateCard(Double valor, String cpf){
        return repository.updateCardLimit(valor, cpf);
    }
}
