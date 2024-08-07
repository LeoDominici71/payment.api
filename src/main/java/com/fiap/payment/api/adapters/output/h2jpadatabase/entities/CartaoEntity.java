package com.fiap.payment.api.adapters.output.h2jpadatabase.entities;

import com.fiap.payment.api.domain.entities.Cartao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_cartao")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class CartaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String limite;
    private String numero;
    private String dataValidade;
    private String cvv;

    public CartaoEntity(Cartao cartao){
        setCpf(cartao.getCpf());
        setLimite(cartao.getLimite());
        setNumero(cartao.getNumero());
        setDataValidade(cartao.getDataValidade());
        setCvv(cartao.getCvv());
    }

}
