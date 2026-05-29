package com.Gym.ejercicio.Client;

import com.Gym.ejercicio.DTO.RutinaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Rutina")
public interface RutinaClient {

    @GetMapping("/api/v1/usuarios/{id_rutina}")
    RutinaDTO getRutina(String id);
}
