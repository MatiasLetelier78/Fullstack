package com.Gym.Pago.DTO;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class MembresiaDTO {

    private String idMembresia;
    private String nombreMembresia;
    private String descripcionMembresia;
    private BigDecimal precioMembresia;
    private Integer duracionDias;
    private Boolean estadoMembresia;
}
