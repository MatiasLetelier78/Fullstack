package com.Gym.rutina.Service;

import com.Gym.rutina.Model.Rutina;
import com.Gym.rutina.Repository.RutinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RutinaService {

    @Autowired
    private RutinaRepository rutinaRepository;

    public List<Rutina> listarRutinas() {
        return rutinaRepository.findAll();
    }

    public Rutina buscarPorId(String id) {
        return rutinaRepository.findById(id).orElse(null);
    }

    public List<Rutina> buscarPorUsuario(String idUsuario) {
        return rutinaRepository.findByIdUsuario(idUsuario);
    }

    public Rutina agregarRutina(Rutina nueva) {
        return rutinaRepository.save(nueva);
    }

    public boolean borrarRutina(String id) {
        if (rutinaRepository.existsById(id)) {
            rutinaRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Rutina actualizarRutina(String id, Rutina nueva) {
        if (rutinaRepository.existsById(id)) {
            Rutina rutina = rutinaRepository.findById(id).get();
            rutina.setNombreRutina(nueva.getNombreRutina());
            rutina.setObjetivoRutina(nueva.getObjetivoRutina());
            rutina.setDescripcionRutina(nueva.getDescripcionRutina());
            rutina.setIdUsuario(nueva.getIdUsuario());
            rutinaRepository.save(rutina);
            return rutina;
        } else {
            return null;
        }
    }
}
