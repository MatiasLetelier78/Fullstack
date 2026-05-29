package com.Gym.rutina.Service;

import com.Gym.rutina.Client.UsuarioClient;
import com.Gym.rutina.Model.Rutina;
import com.Gym.rutina.Repository.RutinaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    public List<Rutina> listarRutinas() {
        log.info("Listando todas las rutinas");
        return rutinaRepository.findAll();
    }

    public Rutina buscarPorId(String id) {
        log.info("Buscando rutina por id {}", id);
        return rutinaRepository.findById(id).orElse(null);
    }

    public List<Rutina> buscarPorUsuario(String idUsuario) {
        log.info("Buscando rutinas por usuario {}", idUsuario);
        return rutinaRepository.findByIdUsuario(idUsuario);
    }

    public Rutina agregarRutina(Rutina nueva) {
        try {
            if (rutinaRepository.existsById(nueva.getIdRutina())) {
                log.error("La rutina ya existe {}", nueva.getIdRutina());
                return null;
            }
            log.info("Agregando rutina {}", nueva);
            return rutinaRepository.save(nueva);
        } catch (Exception e) {
            log.error("Error al agregar rutina {}", nueva);
            return null;
        }
    }

    public boolean borrarRutina(String id) {
        try {
            Rutina rutina = rutinaRepository.findById(id).orElse(null);
            if (rutina != null) {
                log.info("Eliminando rutina {}", id);
                rutinaRepository.delete(rutina);
                return true;
            } else {
                log.error("Rutina no encontrada {}", id);
                return false;
            }
        } catch (Exception e) {
            log.error("Error al borrar rutina {}", id);
            throw new RuntimeException(e);
        }
    }

    public Rutina actualizarRutina(String id, Rutina nueva) {
        try {
            Rutina rutina = rutinaRepository.findById(id).orElse(null);
            if (rutina != null) {
                rutina.setNombreRutina(nueva.getNombreRutina());
                rutina.setObjetivoRutina(nueva.getObjetivoRutina());
                rutina.setDescripcionRutina(nueva.getDescripcionRutina());
                rutina.setIdUsuario(nueva.getIdUsuario());
                log.info("Actualizando rutina {}", id);
                rutinaRepository.save(rutina);
                return rutina;
            } else {
                log.error("Rutina no encontrada {}", id);
                return null;
            }
        } catch (Exception e) {
            log.error("Error al actualizar rutina {}", id);
            throw new RuntimeException(e);
        }
    }
}