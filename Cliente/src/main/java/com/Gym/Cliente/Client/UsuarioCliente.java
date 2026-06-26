package com.Gym.Cliente.Client;

import com.Gym.Cliente.DTO.usuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="usuario")
public interface UsuarioCliente {

    @GetMapping("/api/v1/usuarios/{id_usuario}")
    usuarioDTO getUsuario(String id);
}
