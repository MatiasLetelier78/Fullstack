package com.gym.Sucursal.Service;

import com.gym.Sucursal.Model.Sucursal;
import com.gym.Sucursal.Repository.SucursalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> listarSucursales() {
        log.info("Listando Sucursales");
        return sucursalRepository.findAll();
    }
    public Sucursal buscarSucursalPorCodigoSucursal(String id_sucursal) {
        log.info("Buscando Sucursal");
        return sucursalRepository.findByIdSucursal(id_sucursal);
    }
    public Sucursal buscarSucursalPorNombreSucursal(String nombre_sucursal) {
        log.info("Buscando Sucursal por nombre");
        return sucursalRepository.findByNombreSucursal(nombre_sucursal);
    }

    public Sucursal agregarSucursal(Sucursal sucursal) {
        try {
            if (sucursalRepository.existsById(sucursal.getIdSucursal())) {
                log.error("El Sucursal ya existe");
                return null;
            } else {
                log.info("Agregando Sucursal");
                return sucursalRepository.save(sucursal);
            }
        } catch (Exception e) {
            log.error("Error al Agregar Sucursal");
            throw new RuntimeException(e);
        }
    }
    public boolean borrarSucursalPorCodigoSucursal(String id_sucursal) {
        try {
            if (sucursalRepository.existsById(id_sucursal)) {
                log.info("Borrando Sucursal");
                sucursalRepository.deleteById(id_sucursal);
                return true;
            } else {
                log.error("El Sucursal no existe");
                return false;
            }
        } catch (Exception e) {
            log.error("Error al Borrar Sucursal");
            throw new RuntimeException(e);
        }
    }
    public Sucursal actualizarSucursal(Sucursal sucursal, String id_sucursal) {
        try {
            if (sucursalRepository.existsById(id_sucursal)) {
                Sucursal s = sucursalRepository.findById(id_sucursal).get();
                s.setNombreSucursal(sucursal.getNombreSucursal());
                s.setComunaSucursal(sucursal.getComunaSucursal());
                s.setDireccionSucursal(sucursal.getDireccionSucursal());
                s.setTelefonoSucursal(sucursal.getTelefonoSucursal());
                s.setCapacidadSucursal(sucursal.getCapacidadSucursal());
                log.info("Actualizando Sucursal");
                sucursalRepository.save(s);
                return sucursal;
            } else {
                return null;
            }
        } catch (Exception e) {
            log.error("Error al Actualizar Sucursal");
            throw new RuntimeException(e);
        }
    }
}
