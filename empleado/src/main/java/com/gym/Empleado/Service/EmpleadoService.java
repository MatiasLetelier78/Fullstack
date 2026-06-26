package com.gym.Empleado.Service;


import com.gym.Empleado.Client.UsuarioClient;
import com.gym.Empleado.Model.Empleado;
import com.gym.Empleado.Repository.EmpleadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;


    public List<Empleado> listarEmpleados() {
        log.info("listando empleados");
        return empleadoRepository.findAll();
    }


    public Empleado findByIdUsuario(String idUsuario) {
        log.info("Buscando empleado por idUsuario {}", idUsuario);
        return empleadoRepository.findByIdUsuario(idUsuario);
    }

    public Empleado agregarEmpleado(Empleado nuevo) {
        try {
            if (empleadoRepository.existsById(nuevo.getIdUsuario())) {
                log.error("El empleado ya existe");
                return null;
            } else {
                log.info("Agregando empleado {}", nuevo);
                return empleadoRepository.save(nuevo);
            }
        }catch (Exception e) {
            log.error("Error al agregar empleado {}", nuevo);
            return null;
        }
    }

    public boolean deleteByIdUsuario(String idUsuario){
        try {
            Empleado empleado = empleadoRepository.findByIdUsuario(idUsuario);
            if (empleado != null) {
                log.info("Eliminando empleado {}", idUsuario);
                empleadoRepository.delete(empleado);
                return true;
            } else {
                log.error("Error al eliminar empleado {}", idUsuario);
                return false;
            }
        } catch (Exception e) {
            log.error("Error al eliminar empleado {}", idUsuario);
            throw new RuntimeException(e);
        }
    }
    public Empleado updateEmpleado(String id, Empleado nuevo){
        try {
            Empleado empleado = empleadoRepository.findByIdUsuario(id);
            if (empleado != null) {
                empleado.setCargoEmpleado(nuevo.getCargoEmpleado());
                empleado.setEspecialidadEmpleado(nuevo.getEspecialidadEmpleado());
                empleado.setIdSucursal(nuevo.getIdSucursal());
                empleado.setFechaContratoEmp(nuevo.getFechaContratoEmp());
                log.info("Actualizando empleado {}", id);
                empleadoRepository.save(empleado);
                return empleado;
            } else {
                log.error("Error al actualizar empleado {}", id);
                return null;
            }
        } catch (Exception e) {
            log.error("Error al actualizar empleado {}", id);
            throw new RuntimeException(e);
        }
    }

}
