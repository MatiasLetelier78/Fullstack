package com.gym.Asistencia.Client;

import com.gym.Asistencia.DTO.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="usuario")
public interface UsuarioClient {

    @GetMapping("/api/v1/usuarios/{id_usuario}")
     UsuarioDTO getUsuario(String id_usuario);

}
