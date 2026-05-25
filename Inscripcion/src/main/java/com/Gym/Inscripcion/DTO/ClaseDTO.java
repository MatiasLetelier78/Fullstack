package com.Gym.Inscripcion.DTO;

import lombok.Data;

import java.time.LocalTime;

@Data
public class ClaseDTO {

    private String idClase;
    private String nombreClase;
    private String descripcionClase;
    private Integer duracionMinClase;
    private Integer capacidadClase;
    private LocalTime horaClase;
    private LocalTime horaInicioClase;
    private LocalTime horaTerminoClase;

}
