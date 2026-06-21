package com.gym.Sucursal.Controller;


import com.gym.Sucursal.Model.Sucursal;
import com.gym.Sucursal.Service.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/sucursales")
@Tag(name = "API Sucursal", description = "API para la gestion de sucursales")
@RestController
public class SucursalController {

    @Autowired
    private SucursalService sucursalService;
    @GetMapping("")
    @Operation(summary = "Listar las sucursales",description = "Obtiene la lista de todas las sucursales disponibles")
    @ApiResponse(responseCode = "200", description = "Sucursales encontradas de forma exitosa")
    @ApiResponse(responseCode = "204", description = "No existen sucursales registradas en el sistema")
    public ResponseEntity<List<Sucursal>> getAllSucursales() {
        List<Sucursal> listado = sucursalService.listarSucursales();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{idSucursal}")
    @Operation(summary = "Buscar sucursal por ID", description = "Busca la sucursal disponible mediante su ID")
    @ApiResponse(responseCode = "200", description = "Sucursal localizada correctamente")
    @ApiResponse(responseCode = "404", description = "La sucursal con el ID especificado no existe")
    public ResponseEntity<Sucursal> getSucursalById(@Parameter(description = "ID a buscar") @PathVariable String idSucursal) {
        Sucursal buscado = sucursalService.buscarSucursalPorCodigoSucursal(idSucursal);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/nombre_sucursal/{nombre}")
    @Operation(summary = "Buscar sucursal por NOMBRE", description = "Busca la sucursal disponible mediante su NOMBRE")
    @ApiResponse(responseCode = "200", description = "Sucursal localizada correctamente")
    @ApiResponse(responseCode = "404", description = "La sucursal con el NOMBRE especificado no existe")
    public ResponseEntity<Sucursal> getSucursalByNombre(@Parameter(description = "NOMBRE a buscar")@PathVariable String nombre) {
        Sucursal buscado = sucursalService.buscarSucursalPorNombreSucursal(nombre);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nueva sucursal", description = "Crea una nueva sucursal en la base de datos")
    @ApiResponse(responseCode = "201", description = "Sucursal creada exitosamente")
    @ApiResponse(responseCode = "400", description = "Error al crear la sucursal")
    public ResponseEntity<Sucursal> createSucursal(@RequestBody @Valid Sucursal sucursal) {
        Sucursal nuevo = sucursalService.agregarSucursal(sucursal);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "BORRAR sucursal", description = "Borra la sucursal mediante su ID")
    @ApiResponse(responseCode = "200", description = "Sucursal borrada exitosamente")
    @ApiResponse(responseCode = "400", description = "Error al borrar la sucursal")
    public ResponseEntity<Void> deleteSucursal(@Parameter(description = "ID a buscar")@PathVariable String id) {
        boolean res = sucursalService.borrarSucursalPorCodigoSucursal(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "ACTUALIZAR sucursal", description = "Actualiza la sucursal mediante su ID")
    @ApiResponse(responseCode = "200", description = "Sucursal actualizada exitosamente")
    @ApiResponse(responseCode = "400", description = "Error al actualizar la sucursal")
    public ResponseEntity<Sucursal> updateSucursal(@Parameter(description = "ID a buscar")@PathVariable String id, @RequestBody @Valid Sucursal nuevo) {
        Sucursal actualizado = sucursalService.actualizarSucursal(nuevo, id);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
