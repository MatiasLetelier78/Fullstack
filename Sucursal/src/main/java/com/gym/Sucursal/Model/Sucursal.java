package com.gym.Sucursal.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "sucursal")
public class Sucursal {

    @Id
    @Column(name = "id_sucursal", length = 6, nullable = false)
    private String idSucursal;

    @Column(name = "nombre_sucursal", length = 50, nullable = false)
    private String nombreSucursal;

    @Column(name = "direccion_sucursal", length = 30, nullable = false)
    private String direccionSucursal;

    @Column(name = "comuna_sucursal", length = 30, nullable = false)
    private String comunaSucursal;

    @Column(name = "telefono_sucursal")
    private Long telefonoSucursal;

    @Column(name = "capacidad_sucursal")
    private int capacidadSucursal;
}