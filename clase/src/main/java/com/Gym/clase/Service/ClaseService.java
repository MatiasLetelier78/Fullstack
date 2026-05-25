package com.Gym.clase.Service;

import com.Gym.clase.Model.Clase;
import com.Gym.clase.Repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    public List<Clase> listarClases() {
        return claseRepository.findAll();
    }

    public Clase buscarPorId(String id) {
        return claseRepository.findById(id).orElse(null);
    }

    public List<Clase> buscarPorSucursal(String idSucursal) {
        return claseRepository.findByIdSucursal(idSucursal);
    }

    public Clase agregarClase(Clase nueva) {
        return claseRepository.save(nueva);
    }

    public boolean borrarClase(String id) {
        if (claseRepository.existsById(id)) {
            claseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Clase actualizarClase(String id, Clase nueva) {
        if (claseRepository.existsById(id)) {
            Clase clase = claseRepository.findById(id).get();
            clase.setNombreClase(nueva.getNombreClase());
            clase.setDescripcionClase(nueva.getDescripcionClase());
            clase.setDuracionMinClase(nueva.getDuracionMinClase());
            clase.setCapacidadClase(nueva.getCapacidadClase());
            clase.setHorarioClase(nueva.getHorarioClase());
            clase.setHoraInicioClase(nueva.getHoraInicioClase());
            clase.setHoraTerminoClase(nueva.getHoraTerminoClase());
            clase.setIdSucursal(nueva.getIdSucursal());
            claseRepository.save(clase);
            return clase;
        } else {
            return null;
        }
    }
}