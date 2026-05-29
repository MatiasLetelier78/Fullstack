package com.Gym.Membresia.Respository;

import com.Gym.Membresia.Modelo.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, String> {
    Membresia findByNombreMembresia(String nombreMembresia);
}
