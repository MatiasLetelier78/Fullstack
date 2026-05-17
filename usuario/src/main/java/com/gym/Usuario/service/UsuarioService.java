package com.gym.Usuario.service;

import com.gym.Usuario.model.Usuario;
import com.gym.Usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(String id) {
        return usuarioRepository.findById(id).get();
    }

    public Usuario buscarPorRut(String rut) {
        return usuarioRepository.findByRunUsuario(rut);
    }

    public Usuario agregarUsuario(Usuario nuevo) {
        nuevo.setFechaRegistroUsuario(LocalDate.now());
        return usuarioRepository.save(nuevo);
    }

    public boolean borrarUsuario(String id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Usuario actualizarUsuario(String id, Usuario nuevo) {
        if (usuarioRepository.existsById(id)) {
            Usuario usuario = usuarioRepository.findById(id).get();
            usuario.setRunUsuario(nuevo.getRunUsuario());
            usuario.setPnombreUsuario(nuevo.getPnombreUsuario());
            usuario.setSnombreUsuario(nuevo.getSnombreUsuario());
            usuario.setAppaternoUsuario(nuevo.getAppaternoUsuario());
            usuario.setApmaternoUsuario(nuevo.getApmaternoUsuario());
            usuario.setEmailUsuario(nuevo.getEmailUsuario());
            usuario.setPasswordUsuario(nuevo.getPasswordUsuario()); // Asignación directa sin codificar
            usuario.setTelefonoUsuario(nuevo.getTelefonoUsuario());
            usuario.setFechaNacimientoUsuario(nuevo.getFechaNacimientoUsuario());
            usuario.setRolUsuario(nuevo.getRolUsuario());

            usuarioRepository.save(usuario);
            return usuario;
        } else {
            return null;
        }
    }
}