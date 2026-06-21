package com.gym.Asistencia.Controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gym.Asistencia.Model.Asistencia;
import com.gym.Asistencia.Service.AsistenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("")
    public ResponseEntity<List<Asistencia>> getAllUsuarios() {
        List<Asistencia> listado = asistenciaService.getAsistencias();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Asistencia> getAsistenciaById(@PathVariable String id) {
        Asistencia buscado = asistenciaService.findByIdAsistencia(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id_usuario/{idUsuario}")
    public ResponseEntity<List<Asistencia>> getAsistenciaByIdUsuario(@PathVariable("idUsuario") String idUsuario) {
        List<Asistencia> buscado = asistenciaService.findByIdUsuario(idUsuario);
        if (buscado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }
    }

    @GetMapping("/id_sucursal/{idSucursal}")
    public ResponseEntity<List<Asistencia>> getAsistenciaByIdSucursal(@PathVariable("idSucursal") String idSucursal) {
        List<Asistencia> buscado = asistenciaService.findByIdSucursal(idSucursal);
        if (buscado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Asistencia> createAsistencia(@RequestBody @Valid Asistencia asistencia) {
        Asistencia nuevo = asistenciaService.addAsistencia(asistencia);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAsistencia(@PathVariable String id) {
        boolean res = asistenciaService.deleteAsistenciaByIdAsistencia(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Asistencia> updateUsuario(@PathVariable String id, @RequestBody @Valid Asistencia nuevo) {
        Asistencia actualizado = asistenciaService.updateAsistenciaByIdAsistencia(nuevo,id);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

