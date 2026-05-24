package com.gym.Empleado.Controller;


import com.gym.Empleado.Service.EmpleadoService;
import jakarta.validation.Valid;
import com.gym.Empleado.Model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@RestController
@RequestMapping("/api/v1/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("")
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> listado = empleadoService.listarEmpleados();
        if (listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }

    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Empleado> buscarPorIdUsuario(@PathVariable String idUsuario) {
        Empleado empleado = empleadoService.findByIdUsuario(idUsuario);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Empleado> agregar(@RequestBody @Valid Empleado empleado) {
        Empleado nuevo = empleadoService.agregarEmpleado(empleado);
        if(nuevo!=null){
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> eliminar(@PathVariable String idUsuario) {
        boolean res = empleadoService.deleteByIdUsuario(idUsuario);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<Empleado> actualizar(@PathVariable String idUsuario, @RequestBody @Valid Empleado empleado) {
        Empleado updated = empleadoService.updateEmpleado(idUsuario, empleado);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }
}
