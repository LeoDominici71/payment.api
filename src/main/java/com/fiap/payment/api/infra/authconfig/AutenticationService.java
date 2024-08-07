package com.fiap.payment.api.infra.authconfig;

import com.fiap.payment.api.adapters.input.entities.request.UserDTO;
import com.fiap.payment.api.adapters.output.h2jpadatabase.entities.Usuario;
import com.fiap.payment.api.adapters.output.h2jpadatabase.repository.UsuarioRepository;
import com.fiap.payment.api.infra.exceptions.GeneralClientSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticationService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByLogin(username);
    }

    public UserDTO saveUser(UserDTO user) {
        Usuario usuario = new Usuario(user);
        usuario.setSenha(encoder.encode(user.getSenha()));
        Usuario newUser = repository.save(usuario);
        user.setId(newUser.getId());
        user.setSenha("************");
        return user;
    }

    public UserDTO getUserById(Long id) {
        try {
            Optional<Usuario> usuario = repository.findById(id);

            Usuario newUser = usuario.orElseThrow(() -> new Exception("User not found"));
            return new UserDTO(newUser);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralClientSystemException(e.getMessage());
        }
    }
}
