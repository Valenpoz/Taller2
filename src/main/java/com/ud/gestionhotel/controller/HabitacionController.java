package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.HabitacionService;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.HabitacionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
public class HabitacionController {

    private final HabitacionService habitacionService;

    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @GetMapping
    public ResponseEntity<List<HabitacionEntity>> obtenerTodas() {
        return ResponseEntity.ok(habitacionService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionEntity> obtenerPorId(@PathVariable Long id) {
        return habitacionService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HabitacionEntity> crear(@RequestBody HabitacionEntity habitacion) {
        return ResponseEntity.status(HttpStatus.CREATED).body(habitacionService.crear(habitacion));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HabitacionEntity> actualizar(@PathVariable Long id, @RequestBody HabitacionEntity habitacion) {
        try {
            return ResponseEntity.ok(habitacionService.actualizar(id, habitacion));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        habitacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
