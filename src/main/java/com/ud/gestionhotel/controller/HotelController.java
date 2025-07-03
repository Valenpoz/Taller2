package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.HotelService;
import com.ud.gestionhotel.persistence.HotelEntity;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelEntity>> obtenerTodos() {
        return ResponseEntity.ok(hotelService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelEntity> obtenerPorId(@PathVariable Long id) {
        return hotelService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HotelEntity> crear(@RequestBody HotelEntity hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.crear(hotel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelEntity> actualizar(@PathVariable Long id, @RequestBody HotelEntity hotel) {
        try {
            return ResponseEntity.ok(hotelService.actualizar(id, hotel));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        hotelService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
