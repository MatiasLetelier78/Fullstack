package com.Gym.Inscripcion.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionID implements Serializable {
    private String idUsuario;
    private String idClase;
}
