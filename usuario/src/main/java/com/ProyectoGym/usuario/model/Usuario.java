package com.ProyectoGym.usuario.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Table(name="Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    @Id
    @Column(name = "id_usuario", length = 6, nullable = false)
    private String idUsuario;

    @Column(name = "run_usuario", length = 12, unique = true, nullable = false)
    private String runUsuario;

    @Column(name = "pnombre_usuario", length = 30, nullable = false)
    private String pnombreUsuario;

    @Column(name = "snombre_usuario", length = 30)
    private String snombreUsuario;

    @Column(name = "appaterno_usuario", length = 30, nullable = false)
    private String appaternoUsuario;

    @Column(name = "apmaterno_usuario", length = 30)
    private String apmaternoUsuario;

    @Column(name = "email_usuario", length = 50, unique = true, nullable = false)
    private String emailUsuario;

    @Column(name = "password_usuario", length = 100, nullable = false)
    private String passwordUsuario;

    @Column(name = "telefono_usuario")
    private Long telefonoUsuario;

    @Column(name = "fecha_nacimiento_usuario")
    private LocalDate fechaNacimientoUsuario;

    @Column(name = "rol_usuario", length = 20, nullable = false)
    private String rolUsuario;

    @Column(name = "fecha_registro_usuario")
    private LocalDate fechaRegistroUsuario;

}
