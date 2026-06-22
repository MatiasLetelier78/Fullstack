package com.gym.Usuario.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.gym.Usuario.model.Usuario;
import com.gym.Usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
@Tag(name="API Usuario",description = "API para la gestión de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("")
    @Operation(summary = "Obtener todos los usuarios", description = "Endpoint permite consultar todos los usuarios")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de usuarios")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron usuarios")

    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> listado = usuarioService.listarUsuarios();
        if (listado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }
    }

    @GetMapping("/{idUsuario}")
    @Operation(summary = "Buscar usuario por ID", description = "Retorna los datos de un usuario específico según su ID interno.")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")

    public ResponseEntity<Usuario> getUsuarioById(@Parameter(description = "ID del usuario a consultar") @PathVariable String idUsuario) {
        Usuario buscado = usuarioService.buscarPorId(idUsuario);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/rut/{rut}")
    @Operation(summary = "Buscar usuario por RUT", description = "Permite localizar a un usuario utilizando su RUN.")
    @ApiResponse(responseCode = "200", description = "Usuario encontrado")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")

    public ResponseEntity<Usuario> getUsuarioByRut(@Parameter(description = "RUT del usuario a consultar")@PathVariable String rut) {
        Usuario buscado = usuarioService.buscarPorRut(rut);
        if (buscado != null) {
            return new ResponseEntity<>(buscado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nuevo usuario", description = "Registra un nuevo usuario en la base de datos validando que el ID no exista previamente.")
    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o el usuario ya existe")

    public ResponseEntity<Usuario> createUsuario(@RequestBody @Valid Usuario usuario) {
        Usuario nuevo = usuarioService.agregarUsuario(usuario);
        if (nuevo != null) {
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{idUsuario}")
    @Operation(summary = "Eliminar un usuario", description = "Borra un usuario del sistema utilizando su ID.")
    @ApiResponse(responseCode = "200", description = "Usuario eliminado correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar el usuario (ID no existe)")

    public ResponseEntity<Void> deleteUsuario(@Parameter(description = "ID del usuario a borrar")@PathVariable String idUsuario) {
        boolean res = usuarioService.borrarUsuario(idUsuario);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{idUsuario}")
    @Operation(summary = "Actualizar datos del usuario", description = "Actualiza la información personal de un usuario existente por su ID.")
    @ApiResponse(responseCode = "200", description = "Usuario actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "El usuario no existe o los datos enviados no son válidos")

    public ResponseEntity<Usuario> updateUsuario(@Parameter(description = "ID del usuario a consultar")@PathVariable String idUsuario, @RequestBody @Valid Usuario nuevo) {
        Usuario actualizado = usuarioService.actualizarUsuario(idUsuario, nuevo);
        if (actualizado != null) {
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}