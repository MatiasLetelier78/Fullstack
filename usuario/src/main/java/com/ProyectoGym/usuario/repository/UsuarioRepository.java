package com.ProyectoGym.usuario.repository;

import com.ProyectoGym.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByEmailUsuario(String emailUsuario);

    Optional<Usuario> findByRunUsuario(String runUsuario);

    java.util.List<Usuario> findByRolUsuario(String rolUsuario);
}