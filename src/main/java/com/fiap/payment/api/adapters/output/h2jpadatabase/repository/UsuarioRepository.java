package com.fiap.payment.api.adapters.output.h2jpadatabase.repository;

import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    UserDetails findByLogin(String login);
}
