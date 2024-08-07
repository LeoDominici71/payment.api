package com.fiap.payment.api.domain.repositories;

import com.fiap.payment.api.domain.entities.Pagamento;

import java.util.List;

public interface PagamentoRepository {

    Pagamento registrarPagamento(Pagamento pagamento);

    List<Pagamento> listaDePagamenntos(String userCpf);

}
