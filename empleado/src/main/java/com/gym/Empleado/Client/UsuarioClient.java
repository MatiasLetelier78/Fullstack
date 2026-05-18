package com.gym.Empleado.Client;

import com.gym.Empleado.DTO.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="usuario")
public interface UsuarioClient {

    @GetMapping("/api/v1/usuarios/{id_usuario}")
     UsuarioDTO getUsuario(String id);

}
