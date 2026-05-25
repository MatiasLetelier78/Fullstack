package com.Gym.producto.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Producto")
public class Producto {

    @Id
    @Column(name = "id_producto", length = 6, nullable = false)
    private String idProducto;

    @NotBlank(message = "El nombre del producto es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar 50 caracteres")
    @Column(name = "nombre_producto", nullable = false, length = 50)
    private String nombreProducto;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(name = "precio_producto", nullable = false)
    private Integer precioProducto;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(name = "stock_producto", nullable = false)
    private Integer stockProducto;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 30, message = "La categoría no puede superar 30 caracteres")
    @Column(name = "categoria_producto", nullable = false, length = 30)
    private String categoriaProducto;

    @NotBlank(message = "El id de sucursal es obligatorio")
    @Column(name = "id_sucursal", length = 6, nullable = false)
    private String idSucursal;

    @NotBlank(message = "El id de proveedor es obligatorio")
    @Column(name = "id_proveedor", length = 6, nullable = false)
    private String idProveedor;
}