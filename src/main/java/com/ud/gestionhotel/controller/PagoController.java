package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.PagoService;
import com.ud.gestionhotel.Service.PagoService;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.PagoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/pagoController")
public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping
    public ResponseEntity<List<PagoEntity>> obtenerTodos() {
        return ResponseEntity.ok(PagoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagoEntity> obtenerPorId(@PathVariable Long id) {
        return pagoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PagoEntity> crear(@Valid @RequestBody PagoEntity pago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(PagoService.crear(pago));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PagoEntity> actualizar(@PathVariable Long id, @RequestBody PagoEntity pago) {
        try {
            return ResponseEntity.ok(pagoService.actualizar(id, pago));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
