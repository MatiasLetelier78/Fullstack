package com.gym.Empleado.Controller;


import com.gym.Empleado.Service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import com.gym.Empleado.Model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/v1/empleados")
@Tag(name="API Empleado",description = "API para la gestión de empleados.")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping("")
    @Operation(summary = "Listar los empleados", description = "Obtiene todos los empleados disponibles")
    @ApiResponse(responseCode = "200", description = "Consulta exitosa, se entrega lista de empleados")
    @ApiResponse(responseCode = "204", description = "consulta exitosa, pero no se encontraron empleados")
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> listado = empleadoService.listarEmpleados();
        if (listado.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity<>(listado, HttpStatus.OK);
        }

    }

    @GetMapping("/{idUsuario}")
    @Operation(summary = "Obtener empleado por ID de usuario", description = "Obtiene los empleados por ID de usuario.")
    @ApiResponse(responseCode = "200", description = "Empleado encontrado")
    @ApiResponse(responseCode = "404", description = "Empleado no encontrado")
    public ResponseEntity<Empleado> buscarPorIdUsuario(@PathVariable String idUsuario) {
        Empleado empleado = empleadoService.findByIdUsuario(idUsuario);
        if (empleado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        }
    }

    @PostMapping("/")
    @Operation(summary = "Crear nuevo empleado", description = "Registra un nuevo empleado en la base de datos")
    @ApiResponse(responseCode = "201", description = "Empleado creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos inválidos o empleado ya existente")
    public ResponseEntity<Empleado> agregar(@RequestBody @Valid Empleado empleado) {
        Empleado nuevo = empleadoService.agregarEmpleado(empleado);
        if(nuevo!=null){
            return new ResponseEntity<>(nuevo, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{idUsuario}")
    @Operation(summary = "Eliminar un empleado", description = "Borra un empleado del sistema mediante su ID de usuario.")
    @ApiResponse(responseCode = "200", description = "Empleado eliminado correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar eliminar el empleado (ID no existe)")
    public ResponseEntity<Void> eliminar(@PathVariable String idUsuario) {
        boolean res = empleadoService.deleteByIdUsuario(idUsuario);
        if (res) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{idUsuario}")
    @Operation(summary = "Actualizar un empleado", description = "Actualiza un empleado del sistema mediante su ID de usuario.")
    @ApiResponse(responseCode = "200", description = "Empleado actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Error al intentar actualizar el empleado (ID no existe)")
    public ResponseEntity<Empleado> actualizar(@PathVariable String idUsuario, @RequestBody @Valid Empleado empleado) {
        Empleado updated = empleadoService.updateEmpleado(idUsuario, empleado);
        if (updated == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        }
    }
}
