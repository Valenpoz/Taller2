package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.AdministradorGeneralService;
import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.AdministradorGeneralEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/administradorGeneralController")
public class AdministradorGeneral {

    private final AdministradorGeneralService administradorGeneralService;

    @Autowired
    public AdministradorGeneral(AdministradorGeneralService administradorGeneralService) {
        this.administradorGeneralService = administradorGeneralService;
    }

    @GetMapping
    public ResponseEntity<List<AdministradorGeneralEntity>> obtenerTodos() {
        return ResponseEntity.ok(administradorGeneralService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorGeneralEntity> obtenerPorId(@PathVariable Long id) {
        return administradorGeneralService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdministradorGeneralEntity> crear(@Valid @RequestBody AdministradorGeneralEntity administradorGeneral) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorGeneralService.crear(administradorGeneral));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorGeneralEntity> actualizar(@PathVariable Long id, @RequestBody AdministradorGeneralEntity administradorGeneral) {
        try {
            return ResponseEntity.ok(administradorGeneralService.actualizar(id, administradorGeneral));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        administradorGeneralService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
