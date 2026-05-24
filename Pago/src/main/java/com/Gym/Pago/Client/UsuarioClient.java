package com.Gym.Pago.Client;

import com.Gym.Pago.DTO.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Usuario")
public interface UsuarioClient {

    @GetMapping("/api/v1/usuarios/{id_usuario}")
    UsuarioDTO getUsuario(String id);
}
