package com.Gym.rutina.Controller;

import com.Gym.rutina.Model.Rutina;
import com.Gym.rutina.Service.RutinaService;
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
@RequestMapping("/api/v1/rutinas")
@Tag(name="API Rutina",description = "API para la gestión de rutinas")

public class RutinaController {

    @Autowired
    private RutinaService rutinaService;

    @GetMapping("")
    @Operation(summary = "Obtener todas las rutinas", description = "Endpoint permite consultar todas las rutinas")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de rutinas")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron rutinas")

    public ResponseEntity<List<Rutina>> getAllRutinas() {
        List<Rutina> listado = rutinaService.listarRutinas();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar rutina por ID", description = "Retorna los datos de una rutina en específico según su ID interno.")
    @ApiResponse(responseCode = "200", description = "rutina encontrada")
    @ApiResponse(responseCode = "404", description = "rutina no encontrada")

    public ResponseEntity<Rutina> getRutinaById(@Parameter(description = "ID de la rutina a consultar")@PathVariable String id) {
        Rutina buscada = rutinaService.buscarPorId(id);
        if (buscada != null) {
            return new ResponseEntity<>(buscada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/usuario/{idUsuario}")
    @Operation(summary = "Buscar rutina con Usuario", description = "Permite localizar una rutina utilizando el usuario.")
    @ApiResponse(responseCode = "200", description = "rutina encontrada")
    @ApiResponse(responseCode = "404", description = "rutina no encontrada")

    public ResponseEntity<List<Rutina>> getRutinasByUsuario(@PathVariable String idUsuario) {
        List<Rutina> listado = rutinaService.buscarPorUsuario(idUsuario);
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en la base de datos validando que el ID no exista previamente.")
    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o el usuario ya existe")

    public ResponseEntity<Rutina> createRutina(@RequestBody @Valid Rutina rutina) {
        Rutina nueva = rutinaService.agregarRutina(rutina);
        if (nueva != null) {
            return new ResponseEntity<>(nueva, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una rutina", description = "Borra una rutina del sistema utilizando su ID.")
    @ApiResponse(responseCode = "200", description = "rutina eliminada correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar la rutina (ID no existe)")

    public ResponseEntity<Void> deleteRutina(@PathVariable String id) {
        boolean res = rutinaService.borrarRutina(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar datos de la rutina", description = "Actualiza la información de una rutina existente por su ID.")
    @ApiResponse(responseCode = "200", description = "rutina actualizada exitosamente")
    @ApiResponse(responseCode = "400", description = "la rutina no existe o los datos enviados no son válidos")

    public ResponseEntity<Rutina> updateRutina(@PathVariable String id, @RequestBody @Valid Rutina nueva) {
        Rutina actualizada = rutinaService.actualizarRutina(id, nueva);
        if (actualizada != null) {
            return new ResponseEntity<>(actualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}