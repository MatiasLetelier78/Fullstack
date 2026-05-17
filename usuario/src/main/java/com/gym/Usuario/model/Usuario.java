package com.gym.Usuario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "id_usuario", length = 6, nullable = false)
    private String idUsuario;

    @NotBlank(message = "El RUN es obligatorio")
    @Column(name = "run_usuario", length = 12, unique = true, nullable = false)
    private String runUsuario;

    @NotBlank(message = "El primer nombre es obligatorio")
    @Column(name = "pnombre_usuario", length = 30, nullable = false)
    private String pnombreUsuario;

    @Column(name = "snombre_usuario", length = 30)
    private String snombreUsuario;

    @NotBlank(message = "El apellido paterno es obligatorio")
    @Column(name = "appaterno_usuario", length = 30, nullable = false)
    private String appaternoUsuario;

    @Column(name = "apmaterno_usuario", length = 30)
    private String apmaternoUsuario;

    @Email(message = "Email inválido")
    @NotBlank(message = "El email es obligatorio")
    @Column(name = "email_usuario", length = 50, unique = true, nullable = false)
    private String emailUsuario;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "password_usuario", length = 100, nullable = false)
    private String passwordUsuario;

    @NotNull(message = "El teléfono es obligatorio")
    @Column(name = "telefono_usuario")
    private Long telefonoUsuario;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "Debe ser una fecha pasada")
    @Column(name = "fecha_nacimiento_usuario", nullable = false) // ¡Corregido el "feha"!
    private LocalDate fechaNacimientoUsuario;

    @NotBlank(message = "El rol es obligatorio")
    @Column(name = "rol_usuario", length = 20, nullable = false)
    private String rolUsuario;

    @Column(name = "fecha_registro_usuario", nullable = false)
    private LocalDate fechaRegistroUsuario;
}