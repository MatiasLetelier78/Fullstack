package com.Gym.clase.Controller;

import com.Gym.clase.Model.Clase;
import com.Gym.clase.Service.ClaseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clases")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @GetMapping("")
    public ResponseEntity<List<Clase>> getAllClases() {
        List<Clase> listado = claseService.listarClases();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clase> getClaseById(@PathVariable String id) {
        Clase buscada = claseService.buscarPorId(id);
        if (buscada != null) {
            return new ResponseEntity<>(buscada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sucursal/{idSucursal}")
    public ResponseEntity<List<Clase>> getClasesBySucursal(@PathVariable String idSucursal) {
        List<Clase> listado = claseService.buscarPorSucursal(idSucursal);
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Clase> createClase(@RequestBody @Valid Clase clase) {
        Clase nueva = claseService.agregarClase(clase);
        if (nueva != null) {
            return new ResponseEntity<>(nueva, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClase(@PathVariable String id) {
        boolean res = claseService.borrarClase(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clase> updateClase(@PathVariable String id, @RequestBody @Valid Clase nueva) {
        Clase actualizada = claseService.actualizarClase(id, nueva);
        if (actualizada != null) {
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}