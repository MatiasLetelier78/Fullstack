package com.Gym.Cliente.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class usuarioDTO {
    private String idUsuario;
    private String pnombreUsuario;
    private String snombreUsuario;
    private String appaternoUsuario;
    private String apmaternoUsuario;
    private String emailUsuario;
    private String passwordUsuario;
    private Long telefonoUsuario;
    private LocalDate fechaNacimientoUsuario;
    private String rolUsuario;
    private LocalDate fechaRegistroUsuario;
    private String runUsuario;
}
