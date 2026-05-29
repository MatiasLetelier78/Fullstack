package com.Gym.Inscripcion.Client;

import com.Gym.Inscripcion.DTO.ClaseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clase")
public interface ClaseClient {

    @GetMapping("/api/v1/clase/{idClase}")
    ClaseDTO getClase(@PathVariable String idClase);
}
