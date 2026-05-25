package com.gym.Asistencia.Repository;


import com.gym.Asistencia.AsistenciaApplication;
import com.gym.Asistencia.Model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, String> {
    Asistencia findByIdAsistencia(String idAsistencia);
    List<Asistencia> findByIdUsuario(String idUsuario);
    List<Asistencia> findByIdSucursal(String idSucursal);

}
