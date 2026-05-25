package com.Gym.Membresia.Service;

import com.Gym.Membresia.Modelo.Membresia;
import com.Gym.Membresia.Respository.MembresiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembresiaService{

    @Autowired
    private MembresiaRepository membresiaRepository;

    public List<Membresia> listarMembresias(){ return membresiaRepository.findAll();}

    public Membresia buscarMembresiaPorId(String id){ return membresiaRepository.findById(id).get();}

    public Membresia AgregarMembresia(Membresia membresia){
        membresia.getIdMembresia();
        return membresiaRepository.save(membresia);
    }

    public boolean borrarMembresia(String id) {
        if (membresiaRepository.existsById(id)) {

            membresiaRepository.deleteById(id);
            return true;

        } else {

            return false;
        }
    }

    public Membresia actualizarMembresia(String id, Membresia nueva){
        if (membresiaRepository.existsById(id)){
            Membresia membresia = membresiaRepository.findById(id).get();
            membresia.setIdMembresia(nueva.getIdMembresia());
            membresia.setNombreMembresia(nueva.getNombreMembresia());
            membresia.setDescripcionMembresia(nueva.getDescripcionMembresia());
            membresia.setPrecioMembresia(nueva.getPrecioMembresia());
            membresia.setDuracionDias(nueva.getDuracionDias());
            membresia.setEstadoMembresia(nueva.getEstadoMembresia());
            membresiaRepository.save(membresia);
            return membresia;

        }else{
            return null;
        }
    }
    public Membresia actualizarParcial(String id, Membresia datosActualizados) {
        Membresia membresiaExistente = membresiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Membresía no encontrada con ID: " + id));

        if (datosActualizados.getNombreMembresia() != null) {
            membresiaExistente.setNombreMembresia(datosActualizados.getNombreMembresia());
        }

        if (datosActualizados.getDescripcionMembresia() != null) {
            membresiaExistente.setDescripcionMembresia(datosActualizados.getDescripcionMembresia());
        }

        if (datosActualizados.getPrecioMembresia() != null) {
            membresiaExistente.setPrecioMembresia(datosActualizados.getPrecioMembresia());
        }

        if (datosActualizados.getDuracionDias() != null) {
            membresiaExistente.setDuracionDias(datosActualizados.getDuracionDias());
        }

        if (datosActualizados.getEstadoMembresia() != null) {
            membresiaExistente.setEstadoMembresia(datosActualizados.getEstadoMembresia());
        }

        return membresiaRepository.save(membresiaExistente);
    }
}

