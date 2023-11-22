package com.example.panaderia.controllers;
import com.example.panaderia.models.Comprobante;
import com.example.panaderia.service.ComprobanteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {
    private final ComprobanteService comprobanteService;
    public ComprobanteController(ComprobanteService comprobanteService){
        this.comprobanteService = comprobanteService;
    }
    @GetMapping
    public ResponseEntity<List<Comprobante>> listarComprobante(){
        return new ResponseEntity<List<Comprobante>>(comprobanteService.listar(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Comprobante> agregarComprobante(@RequestBody Comprobante comprobante){
        return  new ResponseEntity<Comprobante>(comprobanteService.crear(comprobante),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Comprobante> actualizarComprobante(@RequestBody Comprobante comprobante){
        Comprobante updatedComprobante = comprobanteService.actualizar(comprobante);
        if (updatedComprobante != null){
            return new ResponseEntity<Comprobante>(updatedComprobante, HttpStatus.OK);
        }else {
            return new ResponseEntity<Comprobante>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarComprobante(@PathVariable("id") Long idComprobante){
        comprobanteService.eliminar(idComprobante);
        return ResponseEntity.ok().build();
    }
}
