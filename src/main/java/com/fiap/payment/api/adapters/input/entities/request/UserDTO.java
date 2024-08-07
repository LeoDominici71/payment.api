package com.fiap.payment.api.adapters.input.entities.request;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {


    private Long id;
    @NotNull
    private String login;
    @NotNull
    private String senha;

    private String roles;


    public UserDTO(Usuario user) {

        setLogin(user.getLogin());
        setSenha(user.getPassword());
        setRoles(user.getRole());

    }


}
