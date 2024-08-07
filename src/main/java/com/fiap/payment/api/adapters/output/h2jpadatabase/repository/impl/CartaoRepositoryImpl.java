package com.fiap.payment.api.adapters.output.h2jpadatabase.repository.impl;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.CartaoEntity;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.JpaCartaoRepository;
import com.fiap.payment.api.domain.entities.Cartao;
import com.fiap.payment.api.domain.repositories.CartaoRepository;
import com.fiap.payment.api.infra.utils.ClassMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class CartaoRepositoryImpl implements CartaoRepository {

    private final JpaCartaoRepository repository;

    public CartaoRepositoryImpl(JpaCartaoRepository repository){
        this.repository = repository;
    }

    @Override
    public Cartao saveCartao(Cartao cartao) {
        return ClassMapper.toCartao(repository.save(new CartaoEntity(cartao)));
    }

    @Override
    public Cartao findByCpf(String cpf) {
        try {
            Optional<CartaoEntity> cartaoEntityOptional = repository.findByCPF(cpf);
            CartaoEntity cartao = cartaoEntityOptional.orElseThrow(() -> new EntityNotFoundException("Not found"));
            return ClassMapper.toCartao(cartao);
        }catch(Exception e){
            CartaoRepositoryImpl.log.info("Cartão nao encontrado");
            return null;
        }
    }

    @Override
    public Cartao updateCardLimit(Double valor, String cpf) {
        Optional<CartaoEntity> cartaoEntityOptional = repository.findByCPF(cpf);
        CartaoEntity cartao = cartaoEntityOptional.orElseThrow(() -> new EntityNotFoundException("Not found"));
        return ClassMapper.toCartao(repository.save(ClassMapper.limitUpdate(cartao, valor)));
    }
}
