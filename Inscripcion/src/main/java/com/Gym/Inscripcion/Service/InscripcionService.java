package com.Gym.Inscripcion.Service;

import com.Gym.Inscripcion.Model.Inscripcion;
import com.Gym.Inscripcion.Model.InscripcionID;
import com.Gym.Inscripcion.Repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    public List<Inscripcion> listarInscripciones() {
        return inscripcionRepository.findAll();
    }

    public List<Inscripcion> findByIdUsuario(String idUsuario) {
        return inscripcionRepository.findByidUsuario(idUsuario);
    }

    public Inscripcion agregarInscripcion(Inscripcion nueva) {
        return inscripcionRepository.save(nueva);
    }

    public boolean deleteInscripcion(String idUsuario, String idClase) {
        InscripcionID id = new InscripcionID(idUsuario, idClase);

        if (inscripcionRepository.existsById(id)) {
            inscripcionRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Inscripcion updateInscripcion(String idUsuario, String idClase, Inscripcion nueva) {
        InscripcionID id = new InscripcionID(idUsuario, idClase);

        Inscripcion inscripcion = inscripcionRepository.findById(id).orElse(null);

        if (inscripcion != null) {
            inscripcion.setFechaInscripcion(nueva.getFechaInscripcion());
            inscripcion.setHoraInscripcion(nueva.getHoraInscripcion());

            inscripcionRepository.save(inscripcion);
            return inscripcion;
        } else {
            return null;
        }
    }
}
