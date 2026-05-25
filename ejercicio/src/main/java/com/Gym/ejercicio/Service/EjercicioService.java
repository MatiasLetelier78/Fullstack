package com.Gym.ejercicio.Service;


import com.Gym.ejercicio.Model.Ejercicio;
import com.Gym.ejercicio.Repository.EjercicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EjercicioService {

    @Autowired
    private EjercicioRepository ejercicioRepository;

    public List<Ejercicio> listarEjercicios() {
        return ejercicioRepository.findAll();
    }

    public Ejercicio buscarPorId(String id) {
        return ejercicioRepository.findById(id).orElse(null);
    }

    public List<Ejercicio> buscarPorRutina(String idRutina) {
        return ejercicioRepository.findByIdRutina(idRutina);
    }

    public Ejercicio agregarEjercicio(Ejercicio nuevo) {
        return ejercicioRepository.save(nuevo);
    }

    public boolean borrarEjercicio(String id) {
        if (ejercicioRepository.existsById(id)) {
            ejercicioRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Ejercicio actualizarEjercicio(String id, Ejercicio nuevo) {
        if (ejercicioRepository.existsById(id)) {
            Ejercicio ejercicio = ejercicioRepository.findById(id).get();
            ejercicio.setNombreEjercicio(nuevo.getNombreEjercicio());
            ejercicio.setGrupoMuscular(nuevo.getGrupoMuscular());
            ejercicio.setDescripcion(nuevo.getDescripcion());
            ejercicio.setSeries(nuevo.getSeries());
            ejercicio.setRepeticiones(nuevo.getRepeticiones());
            ejercicio.setDuracionMinutosEjercicio(nuevo.getDuracionMinutosEjercicio());
            ejercicio.setIdRutina(nuevo.getIdRutina());
            ejercicioRepository.save(ejercicio);
            return ejercicio;
        } else {
            return null;
        }
    }
}

