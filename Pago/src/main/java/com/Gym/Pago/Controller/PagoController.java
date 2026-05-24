package com.Gym.Pago.Controller;

import com.Gym.Pago.Modelo.Pago;
import com.Gym.Pago.Service.PagoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("")
    public ResponseEntity<List<Pago>> getAllUsuarios() {
        List<Pago> listaPagos = pagoService.getPagos();
        if(listaPagos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listaPagos, HttpStatus.OK);
        }
    }

    @GetMapping("/{idPago}")
    public ResponseEntity<Pago> getPagoByIdPago(@PathVariable String idPago){
        Pago BuscaIdPago = pagoService.findByIdPago(idPago);
        if(BuscaIdPago != null){
            return new ResponseEntity<>(BuscaIdPago, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id_usuario/{idUsuario}")
    public ResponseEntity<Pago> getPagoByIdUsuario(@PathVariable String idUsuario){
        Pago BuscaIdUsuario = pagoService.findByIdUsuario(idUsuario);
        if(BuscaIdUsuario != null){
            return new ResponseEntity<>(BuscaIdUsuario, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/id_membresia/{idMembresia}")
    public ResponseEntity<Pago> getPagoByIdMembresia(@PathVariable String idMembresia){
        Pago BuscaIdMembresia = pagoService.findByIdMembresia(idMembresia);
        if(BuscaIdMembresia != null){
            return new ResponseEntity<>(BuscaIdMembresia, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<Pago> crearPago(@RequestBody @Valid Pago pago){
        Pago nuevoPago = pagoService.agregarPago(pago);
        if(nuevoPago != null){
            return new ResponseEntity<>(nuevoPago, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable String id){
        boolean elimPago = pagoService.eliminarPago(id);
        if(elimPago){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizarPago(@PathVariable String id, @RequestBody @Valid Pago pago){
        Pago pagoActualizado = pagoService.actualizarPagoByIdPago(pago,id);
        if(pagoActualizado != null){
            return new ResponseEntity<>(pagoActualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
