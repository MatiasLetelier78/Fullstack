package com.Gym.Inscripcion.Client;

import com.Gym.Inscripcion.DTO.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "usuario")
public interface UsuarioClient {

    @GetMapping("/api/v1/usuario/{idUsuario}")
    UsuarioDTO getCliente(@PathVariable String idUsuario);
}
