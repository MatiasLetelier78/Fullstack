package com.Gym.Cliente.Modelo;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "CLIENTE")
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModelo {

    @Id
    @Column(name = "id_usuario", length = 6, nullable =false)
    private String idUsuario;
}
