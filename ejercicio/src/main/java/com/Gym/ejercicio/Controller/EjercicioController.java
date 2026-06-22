package com.Gym.ejercicio.Controller;

import com.Gym.ejercicio.Model.Ejercicio;
import com.Gym.ejercicio.Service.EjercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ejercicios")
public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("")
    public ResponseEntity<List<Ejercicio>> getAllEjercicios() {
        List<Ejercicio> listado = ejercicioService.listarEjercicios();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ejercicio> getEjercicioById(@PathVariable String id) {
        Ejercicio buscado = ejercicioService.buscarPorId(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rutina/{idRutina}")
    public ResponseEntity<List<Ejercicio>> getEjerciciosByRutina(@PathVariable String idRutina) {
        List<Ejercicio> listado = ejercicioService.buscarPorRutina(idRutina);
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Ejercicio> createEjercicio(@RequestBody @Valid Ejercicio ejercicio) {
        Ejercicio nuevo = ejercicioService.agregarEjercicio(ejercicio);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEjercicio(@PathVariable String id) {
        boolean res = ejercicioService.borrarEjercicio(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ejercicio> updateEjercicio(@PathVariable String id, @RequestBody @Valid Ejercicio nuevo) {
        Ejercicio actualizado = ejercicioService.actualizarEjercicio(id, nuevo);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}