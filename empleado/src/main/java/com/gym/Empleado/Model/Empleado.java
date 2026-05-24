package com.gym.Empleado.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="empleado")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @Column(name = "id_usuario", length = 6, nullable = false)
    private String idUsuario;

    @Column(name = "especialidad_empleado", length = 30, nullable = false)
    private String especialidadEmpleado;

    @Column(name = "cargo_empleado", length = 30, nullable = false)
    private String cargoEmpleado;

    @Column(name = "fecha_contrato_emp", nullable = false)
    private LocalDate fechaContratoEmp;

    @Column(name = "id_sucursal", length = 6, nullable = false)
    private String idSucursal;
}
