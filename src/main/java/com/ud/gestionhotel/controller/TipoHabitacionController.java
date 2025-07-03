package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.TipoHabitacionService;
import com.ud.gestionhotel.persistence.TipoHabitacionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipo-habitaciones")
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;

    @Autowired
    public TipoHabitacionController(TipoHabitacionService tipoHabitacionService) {
        this.tipoHabitacionService = tipoHabitacionService;
    }

    @PostMapping
    public ResponseEntity<TipoHabitacionEntity> crear(@RequestBody TipoHabitacionEntity tipoHabitacion,
                                                      @RequestParam Long idHotel) {
        return ResponseEntity.ok(tipoHabitacionService.crear(tipoHabitacion, idHotel));
    }

    @GetMapping
    public ResponseEntity<List<TipoHabitacionEntity>> obtenerTodos() {
        return ResponseEntity.ok(tipoHabitacionService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacionEntity> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(tipoHabitacionService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoHabitacionEntity> actualizar(@PathVariable Long id,
                                                           @RequestBody TipoHabitacionEntity tipoHabitacion) {
        return ResponseEntity.ok(tipoHabitacionService.actualizar(id, tipoHabitacion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        tipoHabitacionService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
