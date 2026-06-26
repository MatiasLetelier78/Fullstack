package com.Gym.Pago.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name="pago")
@AllArgsConstructor
@NoArgsConstructor
public class Pago {
    @Id
    @Column(name="id_pago", length = 10, nullable = false)
    private String idPago;

    @Column(name = "monto_pago", length = 6, nullable = false)
    private Integer montoPago ;

    @Column(name="fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name="estado_pago", length = 20, nullable = false)
    private String estadoPago;

    @Column(name="metodo_pago", length = 20, nullable = false)
    private String metodoPago;

    @Column(name="id_usuario", length = 6, nullable = false)
    private String idUsuario;

    @Column(name="id_membresia", length = 6, nullable = false)
    private String idMembresia;


}
