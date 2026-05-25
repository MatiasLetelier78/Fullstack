package com.Gym.ejercicio.Repository;


import com.Gym.ejercicio.Model.Ejercicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EjercicioRepository extends JpaRepository<Ejercicio, String> {
    List<Ejercicio> findByIdRutina(String idRutina);
}
