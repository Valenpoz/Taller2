package com.ud.gestionhotel.controller;

import com.ud.gestionhotel.Service.AdministradorGeneralService;
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
@RequestMapping("/api/administradorGeneralController")
public class AdministradorGeneral {

    private final AdministradorGeneralService administradorGeneralService;

    @Autowired
    public AdministradorGeneral(AdministradorGeneralService administradorGeneralService) {
        this.administradorGeneralService = administradorGeneralService;
    }
  /*  @PostMappin
    public ResponseEntity<AdministradorEntity> saveAdministrador(@RequestBody AdministradorEntity administradorEntity){
        return ResponseEntity.ok(AdministradorService.saveAdministrador(administradorEntity));*/

    @GetMapping
    public ResponseEntity<List<AdministradorEntity>> obtenerTodos() {
        return ResponseEntity.ok(administradorGeneralService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorEntity> obtenerPorId(@PathVariable Long id) {
        return administradorGeneralService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AdministradorEntity> crear(@Valid @RequestBody AdministradorEntity administradorGeneral) {
        return ResponseEntity.status(HttpStatus.CREATED).body(administradorGeneralService.crear(administradorGeneral));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdministradorEntity> actualizar(@PathVariable Long id, @RequestBody AdministradorEntity administradorGeneral) {
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
