package com.gym.Usuario.repository;

import com.gym.Usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByRunUsuario(String runUsuario);
}