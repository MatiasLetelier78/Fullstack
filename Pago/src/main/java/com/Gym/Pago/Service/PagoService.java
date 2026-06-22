package com.Gym.Pago.Service;

import com.Gym.Pago.Modelo.Pago;
import com.Gym.Pago.Repository.PagoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getPagos(){
        log.info("Iniciando listado de Pagos ");
        return pagoRepository.findAll();
    }

    public Pago findByIdPago(String idPago){
        log.info("Iniciando listado por busqueda de id de pago {}", idPago);
        return pagoRepository.findByIdPago(idPago);
    }

    public List<Pago> findByIdUsuario(String idUsuario) {
        log.info("Iniciando listado por busqueda de id de usuario {}", idUsuario);
        return pagoRepository.findByIdUsuario(idUsuario);
    }

    public List<Pago> findByIdMembresia(String idMembresia){
        log.info("Iniciando listado por busqueda de id de membresia {}", idMembresia);
        return pagoRepository.findByIdMembresia(idMembresia);
    }

    public Pago agregarPago(Pago pago){
        try {
            if(pagoRepository.existsById(pago.getIdPago())){
                log.warn("Pago existente");
                return null;
            }else{
                log.info("Pago registrado correctamente {}", pago.getIdPago());
                return pagoRepository.save(pago);
            }
        } catch (Exception e ) {
            log.error("Error al agregar un pago {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public boolean eliminarPago(String idPago) {
        try {
            Pago pago = pagoRepository.findByIdPago(idPago);
            if (pago != null) {
                log.info("Eliminando el Pago {}", idPago);
                pagoRepository.delete(pago);
                return true;
            } else {
                log.warn("Error al intentar eliminar el pago {}",idPago);
                return false;
            }
        } catch (Exception e) {
            log.error("Error al eliminar un pago {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Pago actualizarPagoByIdPago(Pago pago, String idPago) {
        try {
            Pago p = pagoRepository.findByIdPago(idPago);
            if (p != null) {
                if (pago.getFechaPago().isAfter(LocalDate.now())) {
                    log.error("Error al actualizar a una fecha anterior ");
                    return null;
                }
                log.info("Actualizando el pago correctamente {}", idPago);
                p.setMontoPago(pago.getMontoPago());
                p.setFechaPago(pago.getFechaPago());
                pagoRepository.save(p);
                return p;
            } else {
                return null;
            }
        }catch(Exception e){
            log.error("Error al actualizar el Pago {}",e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
