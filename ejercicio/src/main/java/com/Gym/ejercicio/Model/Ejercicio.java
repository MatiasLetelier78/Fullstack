package com.Gym.ejercicio.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Ejercicio")

public class Ejercicio {
    @Id
    @NotBlank(message = "el id es obligatorio")
    @Size(max = 6, message = "el id debe tener maximo 6 digitos")
    @Column(name = "id_ejercicio", length = 6, nullable = false)
    private String idEjercicio;

    @NotBlank(message = "el nombre del ejercicio es obligatorio")
    @Size(max = 30, message = "no puede superar los 30 caracteres")
    @Column(name = "nombre_ejercicio", length = 30, nullable = false)
    private String nombreEjercicio;

    @NotBlank(message = "el grupo muscular es obligatorio")
    @Size(max = 30, message = "el maximo de caracteres es 30")
    @Column(name = "grupo_muscular", length = 30, nullable = false)
    private String grupoMuscular;

    @NotBlank(message = " la descripcion es obligatoria")
    @Size(max = 100, message = "la descripcion no puee superar los 100 caracteres")
    @Column(name = "descripcion", length = 100, nullable = false)
    private String descripcion;

    @NotNull(message = "la cantidad de series es obligatoria")
    @Min(value = 1, message = "tiene que ser minimo una serie")
    @Max(value = 99, message = "no puede superar 99 series")
    @Column(name = "series", nullable = false)
    private Integer series;

    @NotNull(message = "la cantidad de repeticiones es obligatoria")
    @Min(value = 1, message = "tiene que ser minimo de una repeticion")
    @Max(value = 999, message = "no puede superar 999 repeticiones")
    @Column(name = "repeticiones", nullable = false)
    private Integer repeticiones;

    @NotNull(message = "ingresar los minutos es obligatorio")
    @Min(value = 1, message = "tiene que ser minimo un minuto")
    @Max(value = 999, message = "no puede superar 999 minutos")
    @Column(name = "duracion_minutos_ejercicio", nullable = false)
    private Integer duracionMinutosEjercicio;

    @NotBlank(message = "el id de la rutina es obligatorio")
    @Size(max = 6, message = "no puede superar los seis digitos")
    @Column(name = "id_rutina", length = 6, nullable = false)
    private String idRutina;
}