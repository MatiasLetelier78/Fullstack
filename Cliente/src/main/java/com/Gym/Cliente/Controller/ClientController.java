package com.Gym.Cliente.Controller;

import com.Gym.Cliente.Modelo.ClienteModelo;
import com.Gym.Cliente.Service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    public ResponseEntity<List<ClienteModelo>> getAllClientes(){
        List<ClienteModelo> listado = clienteService.listarClientes();
        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<ClienteModelo> buscarClientePorId(@PathVariable String idUsuario){
        ClienteModelo cliente = clienteService.buscarClientePorId(idUsuario);
        if(cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ClienteModelo> crearCliente(@RequestBody @Valid ClienteModelo cliente){
        ClienteModelo nuevoCli = clienteService.agregarCliente(cliente);
        if(nuevoCli != null){
            return new ResponseEntity<>(nuevoCli, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/idUsuario")
    public ResponseEntity<Void> borrarCliente(@PathVariable String idUsuario){
        boolean elim = clienteService.borrarCliente(idUsuario);
        if(elim){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<ClienteModelo> actualizarCliente(@PathVariable String idUsuario, @RequestBody @Valid ClienteModelo cliente){
        ClienteModelo actualizado = clienteService.actualizarCliente(cliente);
        if(actualizado != null){
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
