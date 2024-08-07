package com.fiap.payment.api.adapters.output.h2jpadatabase.repository;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.CartaoEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {

    List<PagamentoEntity> findByCpf(String cpf);
}
