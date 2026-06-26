package com.Gym.clase.Controller;

import com.Gym.clase.Model.Clase;
import com.Gym.clase.Service.ClaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clases")
@Tag(name = "Clase", description = "operaciones relacionadas con las clases del gimnasio")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @GetMapping("")
    @Operation(summary = "Listar todas las clases", description = "Retorna una lista con todas las clases disponibles")
    @ApiResponse(responseCode = "200", description = "Clases encontradas")
    @ApiResponse(responseCode = "204", description = "No hay clases registradas")
    public ResponseEntity<List<Clase>> getAllClases() {
        List<Clase> listado = claseService.listarClases();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar clase por ID", description = "Permite localizar una clase utilizando el ID.")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<Clase> getClaseById(@PathVariable String id) {
        Clase buscada = claseService.findByIdClase(id);
        if (buscada != null) {
            return new ResponseEntity<>(buscada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/")
    @Operation(summary = "Crear nueva clase", description = "Registra una nueva clase en la base de datos validando que el ID no exista previamente.")
    @ApiResponse(responseCode = "201", description = "clase creada exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o la clase ya existe")
    public ResponseEntity<Clase> createClase(@RequestBody @Valid Clase clase) {
        Clase nueva = claseService.agregarClase(clase);
        if (nueva != null) {
            return new ResponseEntity<>(nueva, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una clase", description = "Borra una clase del sistema utilizando su ID.")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar el usuario (ID no existe)")
    public ResponseEntity<Void> deleteClase(@PathVariable String id) {
        boolean res = claseService.borrarClase(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos de la clase", description = "Actualiza la información de una clase existente por su ID.")
    @ApiResponse(responseCode = "200", description = "clase actualizada exitosamente")
    @ApiResponse(responseCode = "400", description = "la clase no existe o los datos enviados no son válidos")
    public ResponseEntity<Clase> updateClase(@Parameter(description = "ID de clase a consultar") @PathVariable String id, @RequestBody @Valid Clase nueva) {
        Clase actualizada = claseService.actualizarClase(id, nueva);
        if (actualizada != null) {
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}