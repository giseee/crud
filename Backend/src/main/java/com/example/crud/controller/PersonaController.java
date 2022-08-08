package com.example.crud.controller;

import com.example.crud.entity.PersonaEntity;
import com.example.crud.service.PersonaService;
import com.example.crud.service.PersonaServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping({"/personas"})

public class PersonaController {
    @Autowired
    private PersonaService personaService;

    //cambiar por el dto
    @RequestMapping("listar")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @RequestMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @PostMapping("/add")
    public ResponseEntity<?> save(@RequestBody PersonaEntity persona){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.save(persona));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable  Long id, PersonaEntity personaEntity) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, personaEntity));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"error por favor intente mas tarde\"}");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable  Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(personaService.delete(id));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("{\"error\":\"error por favor intente mas tarde\"}");
        }

    }
}