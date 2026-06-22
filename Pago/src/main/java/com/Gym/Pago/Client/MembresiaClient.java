package com.Gym.Pago.Client;

import com.Gym.Pago.DTO.MembresiaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Membresia")
public interface MembresiaClient {

    @GetMapping("/api/v1/membresia/{id_membresia}")
    MembresiaDTO getUsuario(String id);

}
