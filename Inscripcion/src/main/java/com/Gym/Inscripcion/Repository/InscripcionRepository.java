package com.Gym.Inscripcion.Repository;

import com.Gym.Inscripcion.Model.Inscripcion;
import com.Gym.Inscripcion.Model.InscripcionID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcionID> {
    List<Inscripcion> findByidUsuario(String idUsuario);
}
