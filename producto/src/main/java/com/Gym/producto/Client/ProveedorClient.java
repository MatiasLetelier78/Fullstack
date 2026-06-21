package com.Gym.producto.Client;

import com.Gym.producto.DTO.ProveedorDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Proveedor")
public interface ProveedorClient {

    @GetMapping("/api/v1/usuarios/{id_proveedor}")
    ProveedorDTO getProveedor(String id);
}