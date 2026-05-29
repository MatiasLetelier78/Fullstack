package com.gym.Asistencia.Service;

import com.gym.Asistencia.Model.Asistencia;
import com.gym.Asistencia.Repository.AsistenciaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> getAsistencias() {
        log.info("Iniciando listado de asistencias");
        return asistenciaRepository.findAll();
    }

    public Asistencia findByIdAsistencia(String idAsistencia){
        log.info("Buscando asistencia por ID {}", idAsistencia);
        return asistenciaRepository.findByIdAsistencia(idAsistencia);
    }
    public List<Asistencia> findByIdUsuario(String idUsuario) {
        log.info("Iniciando listado de asistencias del usuario {}", idUsuario);
        return asistenciaRepository.findByIdUsuario(idUsuario);
    }
    public List<Asistencia> findByIdSucursal(String idSucursal) {
        log.info("Iniciando listado de asistencias de la sucursal {}", idSucursal);
        return asistenciaRepository.findByIdSucursal(idSucursal);
    }
    public Asistencia addAsistencia(Asistencia asistencia) {
        try {
            if (asistenciaRepository.existsById(asistencia.getIdAsistencia())) {
                log.warn("Asistencia existente");
                return null;
            } else {
                log.info("Registrando asistencia {}", asistencia.getIdAsistencia());
                return asistenciaRepository.save(asistencia);
            }
        } catch (Exception e) {
            log.error("Error al guardar asistencia: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public boolean deleteAsistenciaByIdAsistencia(String idAsistencia) {
        try {
            Asistencia asistencia = asistenciaRepository.findByIdAsistencia(idAsistencia);
            if (asistencia != null) {
                log.info("Eliminando asistencia {}", idAsistencia);
                asistenciaRepository.delete(asistencia);
                return true;
            } else {
                log.error("Error al eliminar asistencia, id no se encuentra: {}", idAsistencia);
                return false;
            }
        } catch (Exception e) {
            log.error("Error al eliminar asistencia: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
    public Asistencia updateAsistenciaByIdAsistencia(Asistencia asistencia, String idAsistencia) {
        try {
            Asistencia a = asistenciaRepository.findByIdAsistencia(idAsistencia);
            if (a != null) {
                log.info("Actualizando asistencia {}", idAsistencia);
                a.setFechaAsistencia(asistencia.getFechaAsistencia());
                a.setHoraEntrada(asistencia.getHoraEntrada());
                a.setHoraSalida(asistencia.getHoraSalida());
                asistenciaRepository.save(a);
                    return a;
            } else {
                log.error("Error al actualizar asistencia: {}", idAsistencia);
                return null;
            }
        } catch (Exception e) {
            log.error("Error al actualizar asistencia: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

}
