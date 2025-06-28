package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.EmpleadoService;
import com.ud.gestionhotel.Service.FacturaService;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.FacturaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/facturaController")
public class FacturaController {

   private final FacturaService facturaService;
   
   @Autowired
   public FacturaController(FacturaService facturaService) {
       this.facturaService = facturaService;
   }
   
    @GetMapping
    public ResponseEntity<List<FacturaEntity>> obtenerTodos() {
        return ResponseEntity.ok(FacturaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaEntity> obtenerPorId(@PathVariable Long id) {
        return facturaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FacturaEntity> crear(@Valid @RequestBody FacturaEntity factura) {
        return ResponseEntity.status(HttpStatus.CREATED).body(FacturaService.crear(factura));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaEntity> actualizar(@PathVariable Long id, @RequestBody FacturaEntity factura) {
        try {
            return ResponseEntity.ok(facturaService.actualizar(id, factura));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        facturaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
