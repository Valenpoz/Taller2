package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.EmpleadoService;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.EmpleadoEntity;
import com.ud.gestionhotel.persistence.EmpleadoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/empleadoController")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<EmpleadoEntity>> obtenerTodos() {
        return ResponseEntity.ok(EmpleadoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> obtenerPorId(@PathVariable Long id) {
        return empleadoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EmpleadoEntity> crear(@Valid @RequestBody EmpleadoEntity empleado) {
        return ResponseEntity.status(HttpStatus.CREATED).body(EmpleadoService.crear(empleado));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpleadoEntity> actualizar(@PathVariable Long id, @RequestBody EmpleadoEntity empleado) {
        try {
            return ResponseEntity.ok(empleadoService.actualizar(id, empleado));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        empleadoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
