package com.Gym.proveedor.Controller;

import com.Gym.proveedor.Model.Proveedor;
import com.Gym.proveedor.Service.ProveedorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/proveedores")
@Tag(name="API Proveedor",description = "API para la gestión de proveedor")

public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping("")
    @Operation(summary = "Obtener todos los proveedores", description = "Endpoint permite consultar todos los proveedores")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de proveedores")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron proveedores")

    public ResponseEntity<List<Proveedor>> getAllProveedores() {
        List<Proveedor> listado = proveedorService.listarProveedores();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar proveedor por ID", description = "Retorna los datos de un proveedor específico según su ID interno.")
    @ApiResponse(responseCode = "200", description = "proveedor encontrado")
    @ApiResponse(responseCode = "404", description = "proveedor no encontrado")

    public ResponseEntity<Proveedor> getProveedorById(@PathVariable String id) {
        Proveedor buscado = proveedorService.buscarPorId(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rut/{rut}")
    @Operation(summary = "Buscar proveedor por RUT", description = "Permite localizar a un proveedor utilizando su RUN.")
    @ApiResponse(responseCode = "200", description = "proveedor encontrado")
    @ApiResponse(responseCode = "404", description = "proveedor no encontrado")

    public ResponseEntity<Proveedor> getProveedorByRut(@PathVariable String rut) {
        Proveedor buscado = proveedorService.buscarPorRut(rut);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nuevo proveedor", description = "Registra un nuevo proveedor en la base de datos validando que el ID no exista previamente.")
    @ApiResponse(responseCode = "201", description = "proveedor creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o el proveedor ya existe")

    public ResponseEntity<Proveedor> createProveedor(@RequestBody @Valid Proveedor proveedor) {
        Proveedor nuevo = proveedorService.agregarProveedor(proveedor);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un proveedor", description = "Borra un proveedor del sistema utilizando su ID.")
    @ApiResponse(responseCode = "200", description = "proveedor eliminado correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar el proveedor (ID no existe)")

    public ResponseEntity<Void> deleteProveedor(@PathVariable String id) {
        boolean res = proveedorService.borrarProveedor(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos del proveedor", description = "Actualiza la información de un proveedor existente por su ID.")
    @ApiResponse(responseCode = "200", description = "proveedor actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "el proveedor no existe o los datos enviados no son válidos")

    public ResponseEntity<Proveedor> updateProveedor(@PathVariable String id, @RequestBody @Valid Proveedor nuevo) {
        Proveedor actualizado = proveedorService.actualizarProveedor(id, nuevo);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

