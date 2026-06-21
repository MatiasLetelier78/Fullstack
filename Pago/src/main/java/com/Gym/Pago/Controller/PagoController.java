package com.Gym.Pago.Controller;

import com.Gym.Pago.Modelo.Pago;
import com.Gym.Pago.Service.PagoService;
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
@RequestMapping("/api/v1/pagos")
@Tag(name = "API Pago", description = "Endpoints de la API Pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("")
    @Operation(summary = "Listar todos los pagos", description = "Listar todos los pagos existentes")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega una lista de los pagos")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa, pero no se encontraron pagos")
    public ResponseEntity<List<Pago>> getAllUsuarios() {
        List<Pago> listaPagos = pagoService.getPagos();
        if(listaPagos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaPagos, HttpStatus.OK);
        }
    }

    @GetMapping("/{idPago}")
    @Operation(summary = "Obtener el pago por el ID", description = "Obtener el pago por el ID")
    public ResponseEntity<Pago> getPagoByIdPago(@Parameter(description = "ID del pago a consultar") @PathVariable String idPago){
        Pago BuscaIdPago = pagoService.findByIdPago(idPago);
        if(BuscaIdPago != null){
            return new ResponseEntity<>(BuscaIdPago, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id_usuario/{idUsuario}")
    @Operation(summary = "Obtener los pagos por el ID del usuario", description = "Obtener los pagos por el ID del usuario")
    public ResponseEntity<List<Pago>> getPagoByIdUsuario(@Parameter(description = "Pago a consultar en base a la ID de usuario")@PathVariable String idUsuario){
        List<Pago> pagosUsuario = pagoService.findByIdUsuario(idUsuario);
        if(pagosUsuario.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(pagosUsuario, HttpStatus.OK);
        }
    }

    @GetMapping("/id_membresia/{idMembresia}")
    @Operation(summary = "Obtener los pagos por el ID de la membresia", description = "Obtener los pagos por el ID de la membresia")
    public ResponseEntity<List<Pago>> getPagoByIdMembresia(@Parameter(description = "Pagos a consultar en base a la ID de membresia")@PathVariable String idMembresia){
        List<Pago> pagosMembresia = pagoService.findByIdMembresia(idMembresia);
        if(pagosMembresia.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(pagosMembresia,HttpStatus.OK);
        }
    }
    @PostMapping("/")
    @Operation(summary = "Permite agregar un pago en base a su ID")
    @ApiResponse(responseCode = "201", description = "Pago creado y agregado exitosamente")
    public ResponseEntity<Pago> crearPago(@RequestBody @Valid Pago pago){
        Pago nuevoPago = pagoService.agregarPago(pago);
        if(nuevoPago != null){
            return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/{id}")
    @Operation(summary = "Permite eliminar un pago en base a su ID")
    @ApiResponse(responseCode = "204", description = "Pago eliminado exitosamente")
    public ResponseEntity<Void> eliminarPago(@PathVariable String id){
        boolean elimPago = pagoService.eliminarPago(id);
        if(elimPago){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    @Operation(summary = "Permite actualizar un pago en base a su ID")
    @ApiResponse(responseCode = "200", description = "Pago actualizado exitosamente")
    public ResponseEntity<Pago> actualizarPago(@PathVariable String id, @RequestBody @Valid Pago pago){
        Pago pagoActualizado = pagoService.actualizarPagoByIdPago(pago,id);
        if(pagoActualizado != null){
            return new ResponseEntity<>(pagoActualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
