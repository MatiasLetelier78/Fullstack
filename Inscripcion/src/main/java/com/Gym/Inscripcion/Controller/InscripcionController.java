package com.Gym.Inscripcion.Controller;

import com.Gym.Inscripcion.Model.Inscripcion;
import com.Gym.Inscripcion.Service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @GetMapping("")
    public List<Inscripcion> listarInscripciones() {
        return inscripcionService.listarInscripciones();
    }

    @GetMapping("/id_clase/{idClase}")
    public List<Inscripcion> buscarPorIdClase(@PathVariable String idClase) {
        return inscripcionService.findByIdUsuario(idClase);
    }

    @GetMapping("/id_usuario/{idUsuario}")
    public List<Inscripcion> buscarPorIdUsuario(@PathVariable String idUsuario) {
        return inscripcionService.findByIdUsuario(idUsuario);
    }

    @PostMapping("/")
    public Inscripcion agregarInscripcion(@RequestBody Inscripcion nueva) {
        return inscripcionService.agregarInscripcion(nueva);
    }

    @DeleteMapping("/{idUsuario}/{idClase}")
    public boolean eliminarInscripcion(
            @PathVariable String idUsuario,
            @PathVariable String idClase
    ) {
        return inscripcionService.deleteInscripcion(idUsuario, idClase);
    }

    @PutMapping("/{idUsuario}/{idClase}")
    public Inscripcion actualizarInscripcion(
            @PathVariable String idUsuario,
            @PathVariable String idClase,
            @RequestBody Inscripcion nueva
    ) {
        return inscripcionService.updateInscripcion(idUsuario, idClase, nueva);
    }
}
