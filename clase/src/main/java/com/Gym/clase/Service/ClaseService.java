package com.Gym.clase.Service;

import com.Gym.clase.Client.SucursalClient;
import com.Gym.clase.Model.Clase;
import com.Gym.clase.Repository.ClaseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    public List<Clase> listarClases() {
        log.info("Listando todas las clases");
        return claseRepository.findAll();
    }

    public Clase findByIdClase(String idClase) {
        log.info("Buscando clase por id {}", idClase);
        return claseRepository.findById(idClase).orElse(null);
    }

    public Clase agregarClase(Clase nueva) {
        try {
            if (claseRepository.existsById(nueva.getIdClase())) {
                log.error("La clase ya existe {}", nueva.getIdClase());
                return null;
            }
            log.info("Agregando clase {}", nueva);
            return claseRepository.save(nueva);
        } catch (Exception e) {
            log.error("Error al agregar clase {}", nueva);
            return null;
        }
    }

    public boolean borrarClase(String idClase) {
        try {
            Clase clase = claseRepository.findById(idClase).orElse(null);
            if (clase != null) {
                log.info("Eliminando clase {}", idClase);
                claseRepository.delete(clase);
                return true;
            } else {
                log.error("Clase no encontrada {}", idClase);
                return false;
            }
        } catch (Exception e) {
            log.error("Error al borrar clase {}", idClase);
            throw new RuntimeException(e);
        }
    }

    public Clase actualizarClase(String id, Clase nueva) {
        try {
            Clase clase = claseRepository.findById(id).orElse(null);
            if (clase != null) {
                clase.setNombreClase(nueva.getNombreClase());
                clase.setDescripcionClase(nueva.getDescripcionClase());
                clase.setDuracionMinClase(nueva.getDuracionMinClase());
                clase.setCapacidadClase(nueva.getCapacidadClase());
                clase.setHorarioClase(nueva.getHorarioClase());
                clase.setHoraInicioClase(nueva.getHoraInicioClase());
                clase.setHoraTerminoClase(nueva.getHoraTerminoClase());
                clase.setIdSucursal(nueva.getIdSucursal());
                log.info("Actualizando clase {}", id);
                claseRepository.save(clase);
                return clase;
            } else {
                log.error("Clase no encontrada {}", id);
                return null;
            }
        } catch (Exception e) {
            log.error("Error al actualizar clase {}", id);
            throw new RuntimeException(e);
        }
    }
}