package com.gym.Empleado.Service;


import com.gym.Empleado.Model.Empleado;
import com.gym.Empleado.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }


    public Empleado findByIdUsuario(String idUsuario) {
        return empleadoRepository.findByIdUsuario(idUsuario);
    }

    public Empleado agregarEmpleado(Empleado nuevo){
        return empleadoRepository.save(nuevo);
    }
    public boolean deleteByIdUsuario(String idUsuario){
        Empleado empleado = empleadoRepository.findByIdUsuario(idUsuario);
        if(empleado != null){
            empleadoRepository.delete(empleado);
            return true;
        }else{
            return false;
        }
    }
    public Empleado updateEmpleado(String id, Empleado nuevo){
        Empleado empleado = empleadoRepository.findByIdUsuario(id);
        if(empleado != null){
            empleado.setCargoEmpleado(nuevo.getCargoEmpleado());
            empleado.setEspecialidadEmpleado(nuevo.getEspecialidadEmpleado());
            empleado.setIdSucursal(nuevo.getIdSucursal());
            empleado.setFechaContratoEmp(nuevo.getFechaContratoEmp());
            empleadoRepository.save(empleado);
            return empleado;
        }else{
            return null;
        }
    }

}
