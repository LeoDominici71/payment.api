package com.fiap.payment.api.adapters.output.h2jpadatabase.repository;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface JpaClienteRepository extends JpaRepository<ClienteEntity, Long> {

    @Query(value = "SELECT * FROM tb_clientes WHERE cpf = :cpf", nativeQuery = true)
    Optional<ClienteEntity> findByCpf(@Param("cpf") String cpf);

}
