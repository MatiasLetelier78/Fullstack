package com.gym.Asistencia.Controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.gym.Asistencia.Model.Asistencia;
import com.gym.Asistencia.Service.AsistenciaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Listar los usuarios", description = "Obtiene todos los usuarios disponibles")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de usuarios")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron usuarios")
    public ResponseEntity<List<Asistencia>> getAllUsuarios() {
        List<Asistencia> listado = asistenciaService.getAsistencias();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }
    @GetMapping("/{id}")
    @Operation(summary = "Obtener asistencia por ID", description = "Obtiene las asistencias por ID de asistencia.")
    @ApiResponse(responseCode = "200", description = "Asistencia encontrada")
    @ApiResponse(responseCode = "404", description = "Asistencia no encontrada")
    public ResponseEntity<Asistencia> getAsistenciaById(@Parameter(description = "ID de asistencia a consultar")@PathVariable String id) {
        Asistencia buscado = asistenciaService.findByIdAsistencia(id);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id_usuario/{idUsuario}")
    @Operation(summary = "Obtener asistencias por ID de usuario", description = "Obtiene todas las asistencias ligadas a un usuario")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de asistencias por usuario")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron asistencias para el usuario")
    public ResponseEntity<List<Asistencia>> getAsistenciaByIdUsuario(@Parameter(description = "ID del usuario a consultar")@PathVariable("idUsuario") String idUsuario) {
        List<Asistencia> buscado = asistenciaService.findByIdUsuario(idUsuario);
        if (buscado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }
    }

    @GetMapping("/id_sucursal/{idSucursal}")
    @Operation(summary = "Obtener asistencias por ID de Sucursal", description = "Obtiene todas las asistencias ligadas a una sucursal")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de asistencias por sucursal")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron asistencias para la sucursal")
    public ResponseEntity<List<Asistencia>> getAsistenciaByIdSucursal(@Parameter(description = "ID de sucursal a consultar")@PathVariable("idSucursal") String idSucursal) {
        List<Asistencia> buscado = asistenciaService.findByIdSucursal(idSucursal);
        if (buscado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nueva asistencia", description = "Registra una nueva asistencia en la base de datos")
    @ApiResponse(responseCode = "201", description = "Asistencia creada exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o asistencia ya existente")
    public ResponseEntity<Asistencia> createAsistencia(@RequestBody @Valid Asistencia asistencia) {
        Asistencia nuevo = asistenciaService.addAsistencia(asistencia);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una asistencia", description = "Borra una asistencia del sistema mediante su ID.")
    @ApiResponse(responseCode = "200", description = "Asistencia eliminada correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar la asistencia (ID no existe)")
    public ResponseEntity<Void> deleteAsistencia(@Parameter(description = "ID de asistencia a borrar")@PathVariable String id) {
        boolean res = asistenciaService.deleteAsistenciaByIdAsistencia(id);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una asistencia", description = "Actualiza una asistencia del sistema mediante su ID.")
    @ApiResponse(responseCode = "200", description = "Asistencia actualizada correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar actualizar la asistencia (ID no existe)")
    public ResponseEntity<Asistencia> updateUsuario(@Parameter(description = "ID de asistencia a actualizar")@PathVariable String id, @RequestBody @Valid Asistencia nuevo) {
        Asistencia actualizado = asistenciaService.updateAsistenciaByIdAsistencia(nuevo,id);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

