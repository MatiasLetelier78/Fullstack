package com.Gym.Membresia.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "MEMBRESIA")
public class Membresia {
    @Id
    @Column(name = "id_membresia", length = 6, nullable = false)
    private String idMembresia;

    @Column(name = "nombre_membresia", length = 40, nullable = false)
    private String nombreMembresia;

    @Column(name = "descripcion_membresia", length = 100, nullable = false)
    private String descripcionMembresia;

    @Column(name = "precio_membresia", nullable = false)
    private BigDecimal precioMembresia;

    @Column (name = "duracion_dias_memb", nullable = false)
    private Integer duracionDias;

    @Column (name = "activo", nullable = false)
    private Boolean estadoMembresia;

}
