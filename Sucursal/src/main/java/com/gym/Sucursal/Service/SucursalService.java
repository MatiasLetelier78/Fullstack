package com.gym.Sucursal.Service;

import com.gym.Sucursal.Model.Sucursal;
import com.gym.Sucursal.Repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    public List<Sucursal> listarSucursales() {
        return sucursalRepository.findAll();
    }
    public Sucursal buscarSucursalPorCodigoSucursal(String id_sucursal) {
        return sucursalRepository.findByIdSucursal(id_sucursal);
    }
    public Sucursal buscarSucursalPorNombreSucursal(String nombre_sucursal) {
        return sucursalRepository.findByNombreSucursal(nombre_sucursal);
    }

    public Sucursal agregarSucursal(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }
    public boolean borrarSucursalPorCodigoSucursal(String id_sucursal) {
        if (sucursalRepository.existsById(id_sucursal)){
            sucursalRepository.deleteById(id_sucursal);
            return true;
        }else{
            return false;
        }
    }
    public Sucursal actualizarSucursal(Sucursal sucursal, String id_sucursal) {
        if (sucursalRepository.existsById(id_sucursal)){
            Sucursal s= sucursalRepository.findById(id_sucursal).get();
            s.setNombreSucursal(sucursal.getNombreSucursal());
            s.setComunaSucursal(sucursal.getComunaSucursal());
            s.setDireccionSucursal(sucursal.getDireccionSucursal());
            s.setTelefonoSucursal(sucursal.getTelefonoSucursal());
            s.setCapacidadSucursal(sucursal.getCapacidadSucursal());
            sucursalRepository.save(s);
            return sucursal;
        }else{
            return null;
        }
    }
}
