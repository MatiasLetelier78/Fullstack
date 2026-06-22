package com.Gym.Cliente.Repository;

import com.Gym.Cliente.Modelo.ClienteModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModelo, String> {
    ClienteModelo findByidUsuario(String idUsuario);
}
