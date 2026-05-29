package com.Gym.proveedor.Service;

import com.Gym.proveedor.Model.Proveedor;
import com.Gym.proveedor.Repository.ProveedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listarProveedores() {
        log.info("listando todos los proveedores");
        return proveedorRepository.findAll();
    }

    public Proveedor buscarPorId(String id) {
        log.info("buscando proveedor por id {}", id);
        return proveedorRepository.findById(id).orElse(null);
    }

    public Proveedor buscarPorRut(String rut) {
        log.info("buscando proveedor por rut {}", rut);
        return proveedorRepository.findByRutProveedor(rut);
    }

    public Proveedor agregarProveedor(Proveedor nuevo) {
        try {
            if (proveedorRepository.existsById(nuevo.getIdProveedor())) {
                log.error("el proveedor ya existe ");
                return null;
            }
            log.info("agregando proveedor {}", nuevo);
            return proveedorRepository.save(nuevo);
        } catch (Exception e) {
            log.error("error al agregar proveedor ");
            return null;
        }
    }

    public boolean borrarProveedor(String id) {
        try {
            Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
            if (proveedor != null) {
                log.info("eliminando proveedor ");
                proveedorRepository.delete(proveedor);
                return true;
            } else {
                log.error("proveedor no encontrado ");
                return false;
            }
        } catch (Exception e) {
            log.error("error al borrar proveedor ");
            throw new RuntimeException(e);
        }
    }

    public Proveedor actualizarProveedor(String id, Proveedor nuevo) {
        try {
            Proveedor proveedor = proveedorRepository.findById(id).orElse(null);
            if (proveedor != null) {
                proveedor.setNombreProveedor(nuevo.getNombreProveedor());
                proveedor.setRutProveedor(nuevo.getRutProveedor());
                proveedor.setEmailProveedor(nuevo.getEmailProveedor());
                proveedor.setTelefonoProveedor(nuevo.getTelefonoProveedor());
                proveedor.setDireccionProveedor(nuevo.getDireccionProveedor());
                proveedor.setTipoServicio(nuevo.getTipoServicio());
                log.info("actualizando proveedor {}", id);
                proveedorRepository.save(proveedor);
                return proveedor;
            } else {
                log.error("proveedor no encontrado ");
                return null;
            }
        } catch (Exception e) {
            log.error("Error al actualizar proveedor ");
            throw new RuntimeException(e);
        }
    }
}
