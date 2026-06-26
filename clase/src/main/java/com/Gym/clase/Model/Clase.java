package com.Gym.clase.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Clase")
public class Clase {

    @Id
    @NotBlank(message = "el ID de la clase es obligatorio")
    @Size(max=6, message = "el id no puede tener mas de 6 digitos")
    @Column(name = "id_clase", length = 6, nullable = false)
    private String idClase;

    @NotBlank(message = "el nombre de la clase es obligatorio")
    @Size(max = 20, message = "el nombre no puede superar 20 caracteres")
    @Column(name = "nombre_clase", nullable = false, length = 20)
    private String nombreClase;

    @NotBlank(message = "la descripción es obligatoria")
    @Size(max = 100, message = "la descripción no puede superar 100 caracteres")
    @Column(name = "descripcion_clase", nullable = false, length = 100)
    private String descripcionClase;

    @NotNull(message = "la duración es obligatoria")
    @Min(value = 1, message = "la duración debe ser mayor a 0")
    @Column(name = "duracion_min_clase", nullable = false)
    private Integer duracionMinClase;

    @NotNull(message = "la capacidad es obligatoria")
    @Min(value = 1, message = "la capacidad debe ser mayor a 0")
    @Column(name = "capacidad_clase", nullable = false)
    private Integer capacidadClase;

    @NotNull(message = "El horario es obligatorio")
    @Column(name = "horario_clase", nullable = false)
    private LocalDate horarioClase;

    @NotNull(message = "La hora de inicio es obligatoria")
    @Column(name = "hora_inicio_clase", nullable = false)
    private LocalTime horaInicioClase;

    @NotNull(message = "La hora de término es obligatoria")
    @Column(name = "hora_termino_clase", nullable = false)
    private LocalTime horaTerminoClase;

    @NotBlank(message = "El id de sucursal es obligatorio")
    @Column(name = "id_sucursal", length = 6, nullable = false)
    private String idSucursal;
}