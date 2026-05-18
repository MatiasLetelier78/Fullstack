package com.gym.Asistencia.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "asistencia")
public class Asistencia {

    @Id
    @Column(name = "id_asistencia", length = 6, nullable = false)
    private String idAsistencia;

    @Column(name = "fecha_asistencia", nullable = false)
    private LocalDate fechaAsistencia;

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;

    @Column(name = "hora_salida")
    private LocalTime horaSalida;

    @Column(name = "id_usuario", length = 6, nullable = false)
    private String idUsuario;

    @Column(name = "id_sucursal", length = 6, nullable = false)
    private String idSucursal;
}