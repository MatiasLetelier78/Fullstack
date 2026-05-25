package com.Gym.Pago.Service;

import com.Gym.Pago.Modelo.Pago;
import com.Gym.Pago.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public List<Pago> getPagos(){
        return pagoRepository.findAll();
    }

    public Pago findByIdPago(String idPago){
        return pagoRepository.findByIdPago(idPago);
    }

    public List<Pago> findByIdUsuario(String idUsuario) { return pagoRepository.findByIdUsuario(idUsuario); }

    public List<Pago> findByIdMembresia(String idMembresia){
        return pagoRepository.findByIdMembresia(idMembresia);
    }

    public Pago agregarPago(Pago pago){
        return pagoRepository.save(pago);
    }

    public boolean eliminarPago(String idPago){
        Pago pago = pagoRepository.findByIdPago(idPago);
        if(pago != null){
            pagoRepository.delete(pago);
            return true;
        }else{
            return false;
        }
    }


    public Pago actualizarPagoByIdPago(Pago pago, String idPago){
        Pago p = pagoRepository.findByIdPago(idPago);
        if(p != null){

            // ✅ Validación: la fecha de pago no puede ser futura
            if(pago.getFechaPago().isAfter(LocalDate.now())){
                return null; // o puedes lanzar una excepción
            }

            p.setMontoPago(pago.getMontoPago());
            p.setFechaPago(pago.getFechaPago());
            pagoRepository.save(p);
            return p;
        }else{
            return null;
        }
    }
}
