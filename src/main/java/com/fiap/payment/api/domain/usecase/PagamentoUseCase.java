package com.fiap.payment.api.domain.usecase;

import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.entities.Cliente;
import com.fiap.payment.api.domain.entities.Pagamento;
import com.fiap.payment.api.domain.repositories.CartaoRepository;
import com.fiap.payment.api.domain.repositories.ClientRepository;
import com.fiap.payment.api.domain.repositories.PagamentoRepository;
import com.fiap.payment.api.infra.exceptions.GeneralClientSystemException;
import com.fiap.payment.api.infra.exceptions.LimitExcedeedException;
import com.fiap.payment.api.infra.exceptions.MaxNumberOfCardException;

import java.util.List;

public class PagamentoUseCase {

    private final PagamentoRepository repository;

    private final CartaoRepository cartaoRepository;

    private final ClientRepository clientRepository;

    private final ValidaCartao validaCartao;

    public PagamentoUseCase(PagamentoRepository repository, CartaoRepository cartaoRepository, ClientRepository clientRepository, ValidaCartao validaCartao) {
        this.repository = repository;
        this.cartaoRepository = cartaoRepository;
        this.clientRepository = clientRepository;
        this.validaCartao = validaCartao;
    }

    public Pagamento registrarPagamento(Pagamento pagamento) {


        Cartao cartao = cartaoRepository.findByCpf(pagamento.getCpf());

        pagamento.setChavePagamento(validaCartao.validaCartao(cartao, pagamento));

        if (Double.parseDouble(cartao.getLimite()) < pagamento.getValor()) {
            throw new LimitExcedeedException("Limite excedido");
        }
        Cliente cliente = clientRepository.findByCpf(pagamento.getCpf());
        if (cliente == null) {
            throw new GeneralClientSystemException("Cliente não existe");


        }

        pagamento.setClientId(cliente.getId());

        cartaoRepository.updateCardLimit(pagamento.getValor(), pagamento.getCpf());

        return repository.registrarPagamento(pagamento);


    }

    public List<Pagamento> buscarListaDePagamentos(String cpf){
        return repository.listaDePagamenntos(cpf);
    }
}
