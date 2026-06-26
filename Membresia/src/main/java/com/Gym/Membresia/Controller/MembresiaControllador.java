package com.Gym.Membresia.Controller;

import com.Gym.Membresia.Modelo.Membresia;
import com.Gym.Membresia.Service.MembresiaService;
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
@RequestMapping("/api/v1/membresias")
@Tag(name = "API Membresia", description = "Endpoints de la API Membresia")
public class MembresiaControllador{

    @Autowired
    private MembresiaService membresiaService;

    @GetMapping("")
    @Operation(summary = "Listar todas las membresias", description = "Listar todas las membresias existentes")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega una lista de las memebresias")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa, pero no se encontraron membresias")
    public ResponseEntity <List<Membresia>> getAllMembresias(){
        List<Membresia> listado = membresiaService.listarMembresias();
        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{idMembresia}")
    @Operation(summary = "Se busca una membresia en base al Id Membresia")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega la membresia solicitada")
    public ResponseEntity<Membresia> getUsuarioById(@Parameter(description = "ID del paciente a consultar")@PathVariable String idMembresia){
        Membresia buscado = membresiaService.buscarMembresiaPorId(idMembresia);
        if(buscado != null){
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/")
    @Operation(summary = "Permite agregar una memebresia en base a su ID")
    @ApiResponse(responseCode = "201", description = "Membresia creada y agregada exitosamente")
    public ResponseEntity<Membresia> createMembresia(@RequestBody @Valid Membresia membresia){
        Membresia nuevo = membresiaService.AgregarMembresia(membresia);
        if(nuevo != null){
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idMembresia}")
    @Operation(summary = "Permite eliminar una membresia en base a su ID")
    @ApiResponse(responseCode = "204", description = "Membresia eliminada exitosamente")
    public ResponseEntity<Void> deleteMembresia(@Parameter(description = "Id de la Membresia a eliminar")@PathVariable String idMembresia){
        boolean res = membresiaService.borrarMembresia(idMembresia);
        if(res){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idMembresia}")
    @Operation(summary = "Permite actualizar una membresia en base a su ID")
    @ApiResponse(responseCode = "200", description = "Membresia actualizada exitosamente")
    public ResponseEntity<Membresia> updateMembresia(@Parameter(description = "ID de la membresia a actualizar")@PathVariable String idMembresia, @RequestBody @Valid Membresia nueva){
        Membresia actualizado = membresiaService.actualizarMembresia(idMembresia, nueva);
        if(actualizado != null){
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Permite actualizar una parte especifica de una membresia en base a su ID")
    @ApiResponse(responseCode = "200", description = "Membresia actualizada exitosamente")
    public ResponseEntity<Membresia> actualizarParcial(@Parameter(description = "ID de la membresia a actualizar parcialmente")@PathVariable String id, @RequestBody Membresia datosActualizados) {
        Membresia membresiaActualizada = membresiaService.actualizarParcial(id, datosActualizados);
        return ResponseEntity.ok(membresiaActualizada);
    }
}
