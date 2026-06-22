package com.Gym.rutina.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Rutina")
public class Rutina {
    @Id
    @NotBlank(message = "el id de rutina es obligatorio")
    @Size(max=6, message ="el id no puede superar los 6 digitos")
    @Column(name="id_rutina", length = 6, nullable = false)
    private String idRutina;

    @NotBlank(message = "el nombre de la rutina es obligatorio")
    @Size(max = 80, message = "el nombre no puede superar los 80 caracteres")
    @Column(name = "nombre_rutina", length = 80, nullable = false)
    private String nombreRutina;

    @NotBlank(message = "el objetivo es obligatorio")
    @Size(max = 30, message = "el objetivo no puede superar los 30 caracteres")
    @Column(name = "objetivo_rutina", length = 30, nullable = false)
    private String objetivoRutina;

    @NotBlank(message = "la descripcion es obligatoria")
    @Size(max = 100, message = "la descripcion no puede superar los 100 caracteres")
    @Column(name = "descripcion_rutina", length = 100, nullable = false)
    private String descripcionRutina;

    @NotBlank(message = "El id de usuario es obligatorio")
    @Size(max=6, message ="el id no puede superar los 6 digitos")
    @Column(name = "id_usuario", length = 6, nullable = false)
    private String idUsuario;

}
