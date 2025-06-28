package com.ud.gestionhotel.controller;
import com.ud.gestionhotel.Service.AdministradorService;

import com.ud.gestionhotel.exception.RecursoNoEncontradoException;
import com.ud.gestionhotel.persistence.AdministradorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/administradorController")
public class AdministradorController {

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }
  /*  @PostMappin
    public ResponseEntity<AdministradorEntity> saveAdministrador(@RequestBody AdministradorEntity administradorEntity){
        return ResponseEntity.ok(AdministradorService.saveAdministrador(administradorEntity));*/

    @GetMapping
    public ResponseEntity<List<AdministradorEntity>> obtenerTodos() {
        return ResponseEntity.ok(administradorService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorEntity> obtenerPorId(@PathVariable Long id) {
        return administradorService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdministradorEntity> crear(@Valid @RequestBody AdministradorEntity administrador) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorService.crear(administrador));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorEntity> actualizar(@PathVariable Long id, @RequestBody AdministradorEntity administrador) {
        try {
            return ResponseEntity.ok(administradorService.actualizar(id, administrador));
        } catch (RecursoNoEncontradoException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        administradorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
