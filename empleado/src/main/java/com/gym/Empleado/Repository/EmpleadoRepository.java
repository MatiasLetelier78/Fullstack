package com.gym.Empleado.Repository;

import com.gym.Empleado.Model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {
    Empleado findByIdUsuario(String idUsuario);

}
