package com.Gym.proveedor.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.mail.MailException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Proveedor")
public class Proveedor {

    @Id
    @NotBlank(message = "el id es obligatorio")
    @Column(name = "id_proveedor", length = 6, nullable = false)
    @Size( max = 6, message = "no puede llevar mas de seis digitos")
    private String idProveedor;

    @NotBlank(message = "el nombre del proveedor es obligatorio")
    @Size(max = 50, message = "el nombre no puede superar 50 caracteres")
    @Column(name = "nombre_proveedor", nullable = false, length = 50)
    private String nombreProveedor;

    @NotBlank(message = "el RUT es obligatorio")
    @Size(max = 15, message = "el RUT no puede superar 15 caracteres")
    @Column(name = "rut_proveedor", nullable = false, length = 15)
    private String rutProveedor;

    @NotBlank(message = "el email es obligatorio")
    @Email(message = "el email no tiene formato válido")
    @Size(max = 50, message = "el email no puede superar 50 caracteres")
    @Column(name = "email_proveedor", nullable = false, length = 50)
    private String emailProveedor;

    @NotBlank(message = "el teléfono es obligatorio")
    @Size(max = 20, message = "el teléfono no puede superar 20 caracteres")
    @Column(name = "telefono_proveedor", nullable = false, length = 20)
    private String telefonoProveedor;

    @NotBlank(message = "la dirección es obligatoria")
    @Size(max = 50, message = "la dirección no puede superar 50 caracteres")
    @Column(name = "direccion_proveedor", nullable = false, length = 50)
    private String direccionProveedor;

    @NotBlank(message = "el tipo de servicio es obligatorio")
    @Size(max = 30, message = "el tipo de servicio no puede superar 30 caracteres")
    @Column(name = "tipo_servicio", nullable = false, length = 30)
    private String tipoServicio;
}