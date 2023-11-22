package com.example.panaderia.controllers;


import com.example.panaderia.service.InsumoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.panaderia.models.Insumo;

import java.util.*;

@RestController
@RequestMapping("/insumo")
public class InsumoController {
    private final InsumoService insumoService;

    public InsumoController(InsumoService insumoService){
        this.insumoService = insumoService;
    }

    @GetMapping
    public ResponseEntity<List<Insumo>> listarInsumo(){
        return new ResponseEntity<List<Insumo>>(insumoService.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Insumo> agregarInsumo(@RequestBody Insumo insumo){
        return  new ResponseEntity<Insumo>(insumoService.crear(insumo),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Insumo> actualizarInsumo(@RequestBody Insumo insumo){
        Insumo updatedInsumo = insumoService.actualizar(insumo);
        if (updatedInsumo != null){
            return new ResponseEntity<Insumo>(updatedInsumo, HttpStatus.OK);
        }else {
            return new ResponseEntity<Insumo>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarInsumo(@PathVariable("id") Long idInsumo){
        insumoService.eliminar(idInsumo);
        return ResponseEntity.ok().build();
    }
}
