package com.Gym.clase.Client;

import com.Gym.clase.DTO.SucursalDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "Sucursal")
public interface SucursalClient {

    @GetMapping("/api/v1/sucursales/{id}")
    SucursalDTO getSucursal(@PathVariable String id);
}