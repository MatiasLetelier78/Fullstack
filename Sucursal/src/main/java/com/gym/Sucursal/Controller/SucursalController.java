package com.gym.Sucursal.Controller;


import com.gym.Sucursal.Model.Sucursal;
import com.gym.Sucursal.Service.SucursalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/sucursales")
@RestController
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;
    @GetMapping("")
    public ResponseEntity<List<Sucursal>> getAllSucursales() {
        List<Sucursal> listado = sucursalService.listarSucursales();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{idSucursal}")
    public ResponseEntity<Sucursal> getSucursalById(@PathVariable String idSucursal) {
        Sucursal buscado = sucursalService.buscarSucursalPorCodigoSucursal(idSucursal);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre_sucursal/{nombre}")
    public ResponseEntity<Sucursal> getSucursalByNombre(@PathVariable String nombre) {
        Sucursal buscado = sucursalService.buscarSucursalPorNombreSucursal(nombre);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Sucursal> createSucursal(@RequestBody @Valid Sucursal sucursal) {
        Sucursal nuevo = sucursalService.agregarSucursal(sucursal);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSucursal(@PathVariable String id) {
        boolean res = sucursalService.borrarSucursalPorCodigoSucursal(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sucursal> updateSucursal(@PathVariable String id, @RequestBody @Valid Sucursal nuevo) {
        Sucursal actualizado = sucursalService.actualizarSucursal(nuevo, id);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
