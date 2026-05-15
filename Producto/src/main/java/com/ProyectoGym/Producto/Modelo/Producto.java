package com.ProyectoGym.Producto.Modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name="Producto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {
    @Id
    @Column(name = "id_producto", length = 6, nullable = false)
    private String idProducto;

    @Column(name = "nombre_producto", length = 50, nullable = false)
    private String nombreProducto;

    @Column(name = "id_producto", length = 7, nullable = false)
    private Number precioProducto;

    @Column(name = "id_producto", length = 3, nullable = false)
    private Number stockProducto;

    @Column(name = "id_producto", length = 30, nullable = false)
    private String categoriaProducto;

    @Column(name = "id_producto", length = 6, nullable = false)
    private String idSucursal;

    @Column(name = "id_producto", length = 6, nullable = false)
    private String idProveedor;
}
