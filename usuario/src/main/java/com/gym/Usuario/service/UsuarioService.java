package com.gym.Usuario.service;

import com.gym.Usuario.model.Usuario;
import com.gym.Usuario.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        log.info("Listando todos los usuarios");
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(String id) {
        log.info("Buscando usuario {}", id);
        return usuarioRepository.findById(id).get();
    }

    public Usuario buscarPorRut(String rut) {
        log.info("Buscando usuario por rut{}", rut);
        return usuarioRepository.findByRunUsuario(rut);
    }

    public Usuario agregarUsuario(Usuario nuevo) {
        try {
            if (usuarioRepository.existsById(nuevo.getIdUsuario())) {
                log.error("Error, usuario ya existe: {}", nuevo.getIdUsuario());
                return null;
            } else {
                log.info("Agregando usuario {}", nuevo);
                nuevo.setFechaRegistroUsuario(LocalDate.now());
                return usuarioRepository.save(nuevo);
            }
        } catch (Exception e) {
            log.error("Error al agregar usuario {}", nuevo);
            throw new RuntimeException(e);
        }
    }

    public boolean borrarUsuario(String id) {
        try {
            if (usuarioRepository.existsById(id)) {
                log.info("Borrando usuario {}", id);
                usuarioRepository.deleteById(id);
                return true;
            } else {
                log.error("Error al borrar usuario {}", id);
                return false;
            }
        } catch (Exception e) {
            log.error("Error al borrar usuario {}", id);
            throw new RuntimeException(e);
        }
    }

    public Usuario actualizarUsuario(String id, Usuario nuevo) {
        try {
            if (usuarioRepository.existsById(id)) {
                Usuario usuario = usuarioRepository.findById(id).get();
                usuario.setRunUsuario(nuevo.getRunUsuario());
                usuario.setPnombreUsuario(nuevo.getPnombreUsuario());
                usuario.setSnombreUsuario(nuevo.getSnombreUsuario());
                usuario.setAppaternoUsuario(nuevo.getAppaternoUsuario());
                usuario.setApmaternoUsuario(nuevo.getApmaternoUsuario());
                usuario.setEmailUsuario(nuevo.getEmailUsuario());
                usuario.setPasswordUsuario(nuevo.getPasswordUsuario());
                usuario.setTelefonoUsuario(nuevo.getTelefonoUsuario());
                usuario.setFechaNacimientoUsuario(nuevo.getFechaNacimientoUsuario());
                usuario.setRolUsuario(nuevo.getRolUsuario());
                log.info("Actualizando usuario {}", nuevo);
                usuarioRepository.save(usuario);
                return usuario;
            } else {
                log.error("Error al actualizar asistencia: {}", id);
                return null;
            }
        } catch (Exception e) {
            log.error("Error al actualizar usuario {}", nuevo);
            throw new RuntimeException(e);
        }
    }
}