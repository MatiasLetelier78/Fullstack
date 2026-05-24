package com.gym.Asistencia.Client;

import com.gym.Asistencia.DTO.SucursalDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="sucursal")
public interface SucursalClient {

    @GetMapping("/api/v1/sucursales/{id_sucursal}")
    SucursalDTO getSucursales(String id_sucursal);
}
