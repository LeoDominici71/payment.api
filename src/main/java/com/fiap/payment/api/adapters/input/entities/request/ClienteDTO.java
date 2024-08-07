package com.fiap.payment.api.adapters.input.entities.request;

import com.fiap.payment.api.domain.entities.Cliente;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@Setter
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    @CPF
    @NotNull
    private String cpf;
    @NotNull
    private String nome;
    @NotNull
    private String email;
    private String telefone;
    private String rua;
    private String cidade;
    private String estado;
    @NotNull
    private String cep;
    private String pais;


}
