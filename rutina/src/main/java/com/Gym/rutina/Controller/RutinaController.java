package com.Gym.rutina.Controller;

import com.Gym.rutina.Model.Rutina;
import com.Gym.rutina.Service.RutinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rutinas")
public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping("")
    public ResponseEntity<List<Rutina>> getAllRutinas() {
        List<Rutina> listado = rutinaService.listarRutinas();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rutina> getRutinaById(@PathVariable String id) {
        Rutina buscada = rutinaService.buscarPorId(id);
        if (buscada != null) {
            return new ResponseEntity<>(buscada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Rutina>> getRutinasByUsuario(@PathVariable String idUsuario) {
        List<Rutina> listado = rutinaService.buscarPorUsuario(idUsuario);
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Rutina> createRutina(@RequestBody @Valid Rutina rutina) {
        Rutina nueva = rutinaService.agregarRutina(rutina);
        if (nueva != null) {
            return new ResponseEntity<>(nueva, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRutina(@PathVariable String id) {
        boolean res = rutinaService.borrarRutina(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rutina> updateRutina(@PathVariable String id, @RequestBody @Valid Rutina nueva) {
        Rutina actualizada = rutinaService.actualizarRutina(id, nueva);
        if (actualizada != null) {
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}