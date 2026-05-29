package com.Gym.Pago.Repository;

import com.Gym.Pago.Modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, String> {
    Pago findByIdPago(String idPago);
    List<Pago> findByIdUsuario(String idUsuario);
    Pago findByIdMembresia(String idMembresia);
}
