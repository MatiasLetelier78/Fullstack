package com.gym.Asistencia.Service;

import com.gym.Asistencia.Model.Asistencia;
import com.gym.Asistencia.Repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public List<Asistencia> getAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Asistencia findByIdAsistencia(String idAsistencia){
        return asistenciaRepository.findByIdAsistencia(idAsistencia);
    }
    public List<Asistencia> findByIdUsuario(String idUsuario) {
        return asistenciaRepository.findByIdUsuario(idUsuario);
    }
    public List<Asistencia> findByIdSucursal(String idSucursal) {
        return asistenciaRepository.findByIdSucursal(idSucursal);
    }
    public Asistencia addAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }
    public boolean deleteAsistenciaByIdAsistencia(String idAsistencia) {
        Asistencia asistencia = asistenciaRepository.findByIdAsistencia(idAsistencia);
        if (asistencia != null) {
            asistenciaRepository.delete(asistencia);
            return true;
        }else{
            return false;
        }
    }
    public Asistencia updateAsistenciaByIdAsistencia(Asistencia asistencia, String idAsistencia) {
        Asistencia a = asistenciaRepository.findByIdAsistencia(idAsistencia);
        if (a != null) {
            a.setFechaAsistencia(asistencia.getFechaAsistencia());
            a.setHoraSalida(asistencia.getHoraSalida());
            a.setHoraEntrada(asistencia.getHoraEntrada());
            asistenciaRepository.save(a);
            return a;
        }else{
            return null;
        }
    }

}
