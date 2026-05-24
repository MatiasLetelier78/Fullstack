package com.Gym.Inscripcion.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cliente")
public interface ClienteClient {

    @GetMapping("/api/v1/cliente/{id")
    String hola();
}
