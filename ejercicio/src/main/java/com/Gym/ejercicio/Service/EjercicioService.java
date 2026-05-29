package com.Gym.ejercicio.Service;


import com.Gym.ejercicio.Client.RutinaClient;
import com.Gym.ejercicio.Model.Ejercicio;
import com.Gym.ejercicio.Repository.EjercicioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public List<Ejercicio> listarEjercicios() {
        log.info("listando todos los ejercicios");
        return ejercicioRepository.findAll();
    }

    public Ejercicio buscarPorId(String id) {
        log.info("buscando ejercicio por id {}", id);
        return ejercicioRepository.findById(id).orElse(null);
    }

    public List<Ejercicio> buscarPorRutina(String idRutina) {
        log.info("buscando ejercicios por rutina {}", idRutina);
        return ejercicioRepository.findByIdRutina(idRutina);
    }

    public Ejercicio agregarEjercicio(Ejercicio nuevo) {
        try {
            if (ejercicioRepository.existsById(nuevo.getIdEjercicio())) {
                log.error("el ejercicio ya existe {}", nuevo.getIdEjercicio());
                return null;
            }
            log.info("agregando ejercicio {}", nuevo);
            return ejercicioRepository.save(nuevo);
        } catch (Exception e) {
            log.error("error al agregar ejercicio ");
            return null;
        }
    }

    public boolean borrarEjercicio(String id) {
        try {
            Ejercicio ejercicio = ejercicioRepository.findById(id).orElse(null);
            if (ejercicio != null) {
                log.info("eliminando ejercicio {}", id);
                ejercicioRepository.delete(ejercicio);
                return true;
            } else {
                log.error("ejercicio no encontrado ");
                return false;
            }
        } catch (Exception e) {
            log.error("error al borrar ejercicio ");
            throw new RuntimeException(e);
        }
    }

    public Ejercicio actualizarEjercicio(String id, Ejercicio nuevo) {
        try {
            Ejercicio ejercicio = ejercicioRepository.findById(id).orElse(null);
            if (ejercicio != null) {
                ejercicio.setNombreEjercicio(nuevo.getNombreEjercicio());
                ejercicio.setGrupoMuscular(nuevo.getGrupoMuscular());
                ejercicio.setDescripcion(nuevo.getDescripcion());
                ejercicio.setSeries(nuevo.getSeries());
                ejercicio.setRepeticiones(nuevo.getRepeticiones());
                ejercicio.setDuracionMinutosEjercicio(nuevo.getDuracionMinutosEjercicio());
                ejercicio.setIdRutina(nuevo.getIdRutina());
                log.info("actualizando ejercicio {}", id);
                ejercicioRepository.save(ejercicio);
                return ejercicio;
            } else {
                log.error("ejercicio no encontrado ");
                return null;
            }
        } catch (Exception e) {
            log.error("error al actualizar ejercicio ");
            throw new RuntimeException(e);
        }
    }
}