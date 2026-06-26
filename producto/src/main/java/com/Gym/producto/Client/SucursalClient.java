package com.Gym.producto.Client;

import com.Gym.producto.DTO.SucursalDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Sucursal")
public interface SucursalClient {

    @GetMapping("/api/v1/sucursales/{id_sucursal}")
    SucursalDTO getUsuario(String id);
}