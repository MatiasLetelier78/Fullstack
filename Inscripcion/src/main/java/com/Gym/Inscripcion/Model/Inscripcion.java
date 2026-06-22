package com.Gym.Inscripcion.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name="inscripcion")
@IdClass(InscripcionID.class)
public class Inscripcion {

    @Id
    @Column(name = "id_usuario", length = 6, nullable = false)
    private String idUsuario;

    @Id
    @Column(name = "id_clase", length = 6, nullable = false)
    private String idClase;

    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    @Column(name = "hora_inscripcion", nullable = false)
    private LocalTime horaInscripcion;



}
