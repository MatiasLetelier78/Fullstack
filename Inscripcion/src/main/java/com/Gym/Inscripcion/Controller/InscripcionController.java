package com.Gym.Inscripcion.Controller;

import com.Gym.Inscripcion.Model.Inscripcion;
import com.Gym.Inscripcion.Service.InscripcionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscripciones")
@Tag(name = "API Inscripcion", description = "Endpoints de la API Inscripcion")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("")
    @Operation(summary = "Listar todas las inscripciones", description = "Listar todas las inscripciones existentes")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega una lista de las inscripciones")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa, pero no se encontraron inscripciones")
    public ResponseEntity <List<Inscripcion>> listarInscripciones() {
        List<Inscripcion> listado = inscripcionService.listarInscripciones();
        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/id_usuario/{idUsuario}")
    @Operation(summary = "Obtener las inscripciones por el ID de usuario", description = "Obtener las inscripciones por el ID de usuario")
    public ResponseEntity<Inscripcion> buscarPorIdUsuario(@Parameter(description = "ID de la inscripcion a consultar") @PathVariable String idUsuario) {
        List<Inscripcion> buscada = inscripcionService.findByIdUsuario(idUsuario);
        if(buscada.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Agregar una nueva inscripcion", description = "Agregar una nueva inscripcion")
    @ApiResponse(responseCode = "201", description = "Inscripcion creada exitosamente")
    public ResponseEntity<Inscripcion> agregarInscripcion(@RequestBody Inscripcion nueva) {
        Inscripcion inscripcion = inscripcionService.agregarInscripcion(nueva);
        if(inscripcion != null){
            return new ResponseEntity<>(inscripcion, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{idUsuario}/{idClase}")
    @Operation(summary = "Eliminar una inscripcion por el ID de usuario y clase", description = "Eliminar una inscripcion por el ID de usuario y clase")
    @ApiResponse(responseCode = "204", description = "Inscripcion eliminada exitosamente")
    public ResponseEntity<Void> eliminarInscripcion(@PathVariable String idUsuario, @PathVariable String idClase) {
        boolean res = inscripcionService.deleteInscripcion(idUsuario, idClase);
        if(res){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idUsuario}/{idClase}")
    @Operation(summary = "Actualizar una inscripcion por el ID de usuario y clase", description = "Actualizar una inscripcion por el ID de usuario y clase")
    @ApiResponse(responseCode = "200", description = "Inscripcion actualizada exitosamente")
    public ResponseEntity<Inscripcion> updateInscripcion(@PathVariable String idUsuario, @PathVariable String idClase, @RequestBody Inscripcion nueva) {
        Inscripcion updateInscripcion = inscripcionService.updateInscripcion(idUsuario, idClase, nueva);
        if(updateInscripcion != null){
            return new ResponseEntity<>(updateInscripcion, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
