package com.fiap.payment.api.adapters.output.h2jpadatabase.repository;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JpaCartaoRepository extends JpaRepository<CartaoEntity, Long> {

    @Query(value = "SELECT * FROM tb_cartao WHERE cpf = ?1", nativeQuery = true)
    Optional<CartaoEntity> findByCPF(String cpf);

}
