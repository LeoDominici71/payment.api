package com.fiap.payment.api.adapters.output.h2jpadatabase.repository.impl;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.ClienteEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.PagamentoEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaCartaoRepository;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaClienteRepository;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaPagamentoRepository;
import com.fiap.payment.api.domain.entities.Pagamento;
import com.fiap.payment.api.domain.repositories.PagamentoRepository;
import com.fiap.payment.api.infra.utils.ClassMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PagamentoRepositoryImpl implements PagamentoRepository {

    public final JpaPagamentoRepository repository;

    public final JpaClienteRepository clientRepository;

    @Autowired
    public PagamentoRepositoryImpl(JpaPagamentoRepository repository, JpaClienteRepository clientRepository){
        this.repository = repository;
        this.clientRepository = clientRepository;
    }


    @Override
    public Pagamento registrarPagamento(Pagamento pagamento) {
        return ClassMapper.toPagamento(repository.save(new PagamentoEntity(pagamento)));
    }

    @Override
    public List<Pagamento> listaDePagamenntos(String cpf) {
        return repository.findByCpf(cpf).stream().map(ClassMapper::toPagamento).collect(Collectors.toList());
    }
}
