package com.Gym.Cliente.Controller;

import com.Gym.Cliente.Modelo.ClienteModelo;
import com.Gym.Cliente.Service.ClienteService;
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
@RequestMapping("/api/v1/clientes")
@Tag(name = "API Cliente", description = "Endpoints de la API Cliente")
public class ClientController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("")
    @Operation(summary = "Listar todos los clientes", description = "Listar todos los clientes existentes")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega una lista de los clientes")
    @ApiResponse(responseCode = "204", description = "Consulta exitosa, pero no se encontraron clientes")
    public ResponseEntity<List<ClienteModelo>> getAllClientes(){
        List<ClienteModelo> listado = clienteService.listarClientes();
        if(listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{idUsuario}")
    @Operation(summary = "Obtener el pago por el ID", description = "Obtener el pago por el ID")
    public ResponseEntity<ClienteModelo> buscarClientePorId(@Parameter(description = "ID del cliente a consultar")@PathVariable String idUsuario){
        ClienteModelo cliente = clienteService.buscarClientePorId(idUsuario);
        if(cliente != null){
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear un nuevo cliente", description = "Crear un nuevo cliente")
    @ApiResponse(responseCode = "201", description = "Cliente creado exitosamente")
    public ResponseEntity<ClienteModelo> crearCliente(@RequestBody @Valid ClienteModelo cliente){
        ClienteModelo nuevoCli = clienteService.agregarCliente(cliente);
        if(nuevoCli != null){
            return new ResponseEntity<>(nuevoCli, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/idUsuario")
    @Operation(summary = "Eliminar un cliente por su ID", description = "Eliminar un cliente por su ID")
    @ApiResponse(responseCode = "204", description = "Cliente eliminado exitosamente")
    public ResponseEntity<Void> borrarCliente(@PathVariable String idUsuario){
        boolean elim = clienteService.borrarCliente(idUsuario);
        if(elim){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idUsuario}")
    @Operation(summary = "Actualizar un cliente por su ID", description = "Actualizar un cliente por su ID")
    @ApiResponse(responseCode = "200", description = "Cliente actualizado exitosamente")
    public ResponseEntity<ClienteModelo> actualizarCliente(@PathVariable String idUsuario, @RequestBody @Valid ClienteModelo cliente){
        ClienteModelo actualizado = clienteService.actualizarCliente(cliente);
        if(actualizado != null){
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
