package com.Gym.Membresia.Controller;

import com.Gym.Membresia.Modelo.Membresia;
import com.Gym.Membresia.Service.MembresiaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/membresias")
public class MembresiaControllador {

    @Autowired
    private MembresiaService membresiaService;

    @GetMapping("")
    public ResponseEntity <List<Membresia>> getAllMembresias(@PathVariable String idMembresia){
        List<Membresia> listado = membresiaService.listarMembresias();
        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{idMembresia}")
    public ResponseEntity<Membresia> getUsuarioById(@PathVariable String idMembresia){
        Membresia buscado = membresiaService.buscarMembresiaPorId(idMembresia);
        if(buscado != null){
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Membresia> createMembresia(@RequestBody @Valid Membresia membresia){
        Membresia nuevo = membresiaService.AgregarMembresia(membresia);
        if(nuevo != null){
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idMembresia}")
    public ResponseEntity<Void> deleteMembresia(@PathVariable String idMembresia){
        boolean res = membresiaService.borrarMembresia(idMembresia);
        if(res){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idMembresia}")
    public ResponseEntity<Membresia> updateMembresia(@PathVariable String idMembresia, @RequestBody @Valid Membresia nueva){
        Membresia actualizado = membresiaService.actualizarMembresia(idMembresia, nueva);
        if(actualizado != null){
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}
