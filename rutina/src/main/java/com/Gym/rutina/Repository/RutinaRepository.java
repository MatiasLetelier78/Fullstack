package com.Gym.rutina.Repository;

import com.Gym.rutina.Model.Rutina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RutinaRepository extends JpaRepository<Rutina, String> {
    List<Rutina> findByIdUsuario(String idUsuario);
}