package com.example.panaderia.controllers;
import com.example.panaderia.models.Receta;
import com.example.panaderia.service.RecetaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/receta")
public class RecetaController {
    private final RecetaService recetaService;

    public RecetaController(RecetaService recetaService){
        this.recetaService = recetaService;
    }

    @GetMapping
    public ResponseEntity<List<Receta>> listarReceta(){
        return new ResponseEntity<List<Receta>>(recetaService.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Receta> agregarReceta(@RequestBody Receta receta){
        return  new ResponseEntity<Receta>(recetaService.crear(receta),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Receta> actualizarReceta(@RequestBody Receta receta){
        Receta updatedReceta = recetaService.actualizar(receta);
        if (updatedReceta != null){
            return new ResponseEntity<Receta>(updatedReceta, HttpStatus.OK);
        }else {
            return new ResponseEntity<Receta>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReceta(@PathVariable("id") Long idReceta){
        recetaService.eliminar(idReceta);
        return ResponseEntity.ok().build();
    }
}
