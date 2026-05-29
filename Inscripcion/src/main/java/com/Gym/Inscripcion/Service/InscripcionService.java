package com.Gym.Inscripcion.Service;

import com.Gym.Inscripcion.Model.Inscripcion;
import com.Gym.Inscripcion.Model.InscripcionID;
import com.Gym.Inscripcion.Repository.InscripcionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> listarInscripciones() {
        log.info("Iniciando listado de inscripciones");
        return inscripcionRepository.findAll();
    }

    public List<Inscripcion> findByIdUsuario(String idUsuario) {
        log.info("Iniciando el listado por busqueda de id de usuario {}",idUsuario);
        return inscripcionRepository.findByidUsuario(idUsuario);
    }
    public Inscripcion agregarInscripcion(Inscripcion nueva) {
        try {
            InscripcionID id = new InscripcionID(nueva.getIdUsuario(), nueva.getIdClase());
            if (inscripcionRepository.existsById(id)) {
                log.warn("La inscripción ya existe para el usuario {} y la clase {}", nueva.getIdUsuario(), nueva.getIdClase());
                return null;
            } else {
                log.info("Registrando inscripción para el usuario {} en la clase {}", nueva.getIdUsuario(), nueva.getIdClase());
                return inscripcionRepository.save(nueva);
            }
        }catch (Exception e){
            log.error("Error al agregar inscripcion {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean deleteInscripcion(String idUsuario, String idClase) {
        try {
            InscripcionID id = new InscripcionID(idUsuario, idClase);
            if(id != null){
                log.info("Eliminando la inscripcion con id de Clase {} y id de Usuario {}",idClase, idUsuario);
                inscripcionRepository.deleteById(id);
                return true;
            }else {
                log.warn("Error al intentar eliminar la inscripcion con id de clase {} y id de usuario {}",idClase, idUsuario) ;
                return false;
            }
        }catch (Exception e){
            log.error("Error al eliminar la inscripcion {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Inscripcion updateInscripcion(String idUsuario, String idClase, Inscripcion nueva) {
        try {
            InscripcionID id = new InscripcionID(idUsuario, idClase);
            Inscripcion inscripcion = inscripcionRepository.findById(id).orElse(null);
            if (inscripcion != null) {
                log.info("Actualizando la inscripcion con id de usuario {} y con id de clase {}", idUsuario, idClase);
                inscripcion.setFechaInscripcion(nueva.getFechaInscripcion());
                inscripcion.setHoraInscripcion(nueva.getHoraInscripcion());

                inscripcionRepository.save(inscripcion);
                return inscripcion;
            } else {
                log.warn("No se encontró inscripción con idUsuario {} e idClase {}", idUsuario, idClase);
                return null;
            }
        }catch (Exception e){
            log.error("Error al actualizar la Inscripcion {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
