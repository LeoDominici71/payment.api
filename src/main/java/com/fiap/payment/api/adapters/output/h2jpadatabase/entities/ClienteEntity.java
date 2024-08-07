package com.fiap.payment.api.adapters.output.h2jpadatabase.entities;

import com.fiap.payment.api.domain.entities.Cliente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tb_clientes")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String nome;
    private String email;
    private String telefone;
    private String rua;
    private String cidade;
    private String estado;
    private String cep;
    private String pais;

    public ClienteEntity(Cliente cliente){
        setCpf(cliente.getCpf());
        setNome(cliente.getNome());
        setEmail(cliente.getEmail());
        setTelefone(cliente.getTelefone());
        setRua(cliente.getRua());
        setCidade(cliente.getCidade());
        setEstado(cliente.getEstado());
        setCep(cliente.getCep());
        setPais(cliente.getPais());
    }

}
