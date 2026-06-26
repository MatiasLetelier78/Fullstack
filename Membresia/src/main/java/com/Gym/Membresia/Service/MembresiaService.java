package com.Gym.Membresia.Service;

import com.Gym.Membresia.Modelo.Membresia;
import com.Gym.Membresia.Respository.MembresiaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class MembresiaService{

    @Autowired
    private MembresiaRepository membresiaRepository;

    public List<Membresia> listarMembresias(){
        log.info("Iniciando listado de las membresias ");
        return membresiaRepository.findAll();
    }

    public Membresia buscarMembresiaPorId(String idMembresia){
        log.info("Iniciando listado por busqueda de ID {}", idMembresia);
        return membresiaRepository.findById(idMembresia).get();
    }

    public Membresia AgregarMembresia(Membresia membresia){
        try {
            if(membresiaRepository.existsById(membresia.getIdMembresia())) {
                log.warn("Membresia existente {}", membresia);
                return null;
            }else{
                log.info("Agregando nueva membresia {}", membresia);
                membresia.getIdMembresia();
                return membresiaRepository.save(membresia);
            }
        }catch(Exception e){
            log.error("Error al agregar la membresia {}", e.getMessage());
            throw new RuntimeException(e);
        }

    }

    public boolean borrarMembresia(String idMembresia) {
        try {
            if (membresiaRepository.existsById(idMembresia)) {
                log.info("Eliminando la membresia {}", idMembresia);
                membresiaRepository.deleteById(idMembresia);
                return true;
            } else {
                log.error("Error al eliminar la Membresia {}",idMembresia);
                return false;
            }
        }catch (Exception e){
            log.error("Error al eliminar la membresia {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Membresia actualizarMembresia(String idMembresia, Membresia nueva){
        try {
            if (membresiaRepository.existsById(idMembresia)) {
                log.info("Actualisando la Membresia {}", idMembresia);
                Membresia membresia = membresiaRepository.findById(idMembresia).get();
                membresia.setIdMembresia(nueva.getIdMembresia());
                membresia.setNombreMembresia(nueva.getNombreMembresia());
                membresia.setDescripcionMembresia(nueva.getDescripcionMembresia());
                membresia.setPrecioMembresia(nueva.getPrecioMembresia());
                membresia.setDuracionDias(nueva.getDuracionDias());
                membresia.setEstadoMembresia(nueva.getEstadoMembresia());
                membresiaRepository.save(membresia);
                return membresia;
            } else {
                log.error("Error al actualiazar la Membresia {}", idMembresia);
                return null;
            }
        }catch (Exception e){
            log.error("Error al actualizar la Membresia {}", idMembresia);
            throw new RuntimeException(e);
        }
    }
    public Membresia actualizarParcial(String idMembresia, Membresia datosActualizados) {
        try {
            Membresia membresiaExistente = membresiaRepository.findById(idMembresia).orElseThrow(() -> new RuntimeException("Membresía no encontrada con ID: " + idMembresia));
            if (datosActualizados.getNombreMembresia() != null) {
                log.info("Nombre de la membresia actualizado {}", idMembresia);
                membresiaExistente.setNombreMembresia(datosActualizados.getNombreMembresia());
            }
            if (datosActualizados.getDescripcionMembresia() != null) {
                log.info("Descripcion de la membresia actualizado {}", idMembresia);
                membresiaExistente.setDescripcionMembresia(datosActualizados.getDescripcionMembresia());
            }
            if (datosActualizados.getPrecioMembresia() != null) {
                log.info("Precio de la membresia actualizado {}", idMembresia);
                membresiaExistente.setPrecioMembresia(datosActualizados.getPrecioMembresia());
            }
            if (datosActualizados.getDuracionDias() != null) {
                log.info("Duracion de la membresia actualizado {}", idMembresia);
                membresiaExistente.setDuracionDias(datosActualizados.getDuracionDias());
            }
            if (datosActualizados.getEstadoMembresia() != null) {
                log.info("Estado de la  membresia actualizado {}", idMembresia);
                membresiaExistente.setEstadoMembresia(datosActualizados.getEstadoMembresia());
            }
            return membresiaRepository.save(membresiaExistente);
        }catch (Exception e){
            log.error("Error al actualizar la membresia {}", idMembresia);
            throw new RuntimeException(e);
        }
    }
}

