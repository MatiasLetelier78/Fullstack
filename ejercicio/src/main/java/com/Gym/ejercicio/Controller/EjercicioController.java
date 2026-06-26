package com.Gym.ejercicio.Controller;

import com.Gym.ejercicio.Model.Ejercicio;
import com.Gym.ejercicio.Service.EjercicioService;
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
@RequestMapping("/api/v1/ejercicios")
@Tag(name="API Ejercicio",description = "API para la gestión de ejercicios")

public class EjercicioController {

    @Autowired
    private EjercicioService ejercicioService;

    @GetMapping("")
    @Operation(summary = "Obtener todos los ejercicios", description = "Endpoint permite consultar todos los ejercicios")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de ejercicios")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron ejercicios")

    public ResponseEntity<List<Ejercicio>> getAllEjercicios() {
        List<Ejercicio> listado = ejercicioService.listarEjercicios();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar ejercicio por ID", description = "Retorna los datos de un ejercicio específico según su ID interno.")
    @ApiResponse(responseCode = "200", description = "ejercicio encontrado")
    @ApiResponse(responseCode = "404", description = "ejercicio no encontrado")

    public ResponseEntity<Ejercicio> getEjercicioById(@Parameter(description = "ID del ejercicio a consultar")@PathVariable String id) {
        Ejercicio buscado = ejercicioService.buscarPorId(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rutina/{idRutina}")
    @Operation(summary = "Buscar ejercicio por Rutina", description = "Permite localizar un ejercicio utilizando la rutina.")
    @ApiResponse(responseCode = "200", description = "Ejercicio encontrado")
    @ApiResponse(responseCode = "404", description = "Ejercicio no encontrado")

    public ResponseEntity<List<Ejercicio>> getEjerciciosByRutina(@PathVariable String idRutina) {
        List<Ejercicio> listado = ejercicioService.buscarPorRutina(idRutina);
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nuevo ejercicio", description = "Registra un nuevo ejercicio en la base de datos validando que el ID no exista previamente.")
    @ApiResponse(responseCode = "201", description = "ejercicio creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o el ejercicio ya existe")

    public ResponseEntity<Ejercicio> createEjercicio(@RequestBody @Valid Ejercicio ejercicio) {
        Ejercicio nuevo = ejercicioService.agregarEjercicio(ejercicio);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un ejercicio", description = "Borra un ejercicio del sistema utilizando su ID.")
    @ApiResponse(responseCode = "200", description = "ejercicio eliminado correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar el ejercicio(ID no existe)")

    public ResponseEntity<Void> deleteEjercicio(@PathVariable String id) {
        boolean res = ejercicioService.borrarEjercicio(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos del ejercicio", description = "Actualiza la información personal de un ejercicio existente por su ID.")
    @ApiResponse(responseCode = "200", description = "ejercicio actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "El ejercicio no existe o los datos enviados no son válidos")

    public ResponseEntity<Ejercicio> updateEjercicio(@PathVariable String id, @RequestBody @Valid Ejercicio nuevo) {
        Ejercicio actualizado = ejercicioService.actualizarEjercicio(id, nuevo);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}