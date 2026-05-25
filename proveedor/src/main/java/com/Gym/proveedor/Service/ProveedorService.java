package com.Gym.proveedor.Service;

import com.Gym.proveedor.Model.Proveedor;
import com.Gym.proveedor.Repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor buscarPorId(String id) {
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor buscarPorRut(String rut) {
        return proveedorRepository.findByRutProveedor(rut);
    }

    public Proveedor agregarProveedor(Proveedor nuevo) {
        return proveedorRepository.save(nuevo);
    }

    public boolean borrarProveedor(String id) {
        if (proveedorRepository.existsById(id)) {
            proveedorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Proveedor actualizarProveedor(String id, Proveedor nuevo) {
        if (proveedorRepository.existsById(id)) {
            Proveedor proveedor = proveedorRepository.findById(id).get();
            proveedor.setNombreProveedor(nuevo.getNombreProveedor());
            proveedor.setRutProveedor(nuevo.getRutProveedor());
            proveedor.setEmailProveedor(nuevo.getEmailProveedor());
            proveedor.setTelefonoProveedor(nuevo.getTelefonoProveedor());
            proveedor.setDireccionProveedor(nuevo.getDireccionProveedor());
            proveedor.setTipoServicio(nuevo.getTipoServicio());
            proveedorRepository.save(proveedor);
            return proveedor;
        } else {
            return null;
        }
    }
}