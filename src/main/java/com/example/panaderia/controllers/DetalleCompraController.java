package com.example.panaderia.controllers;
import com.example.panaderia.models.DetalleCompra;
import com.example.panaderia.service.DetalleCompraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/detalleCompra")
public class DetalleCompraController {
    private final DetalleCompraService detalleCompraService;
    public DetalleCompraController(DetalleCompraService detalleCompraService){
        this.detalleCompraService = detalleCompraService;
    }
    @GetMapping
    public ResponseEntity<List<DetalleCompra>> listarDetalleCompra(){
        return new ResponseEntity<List<DetalleCompra>>(detalleCompraService.listar(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<DetalleCompra> agregarDetalleCompra(@RequestBody DetalleCompra detalleCompra){
        return  new ResponseEntity<DetalleCompra>(detalleCompraService.crear(detalleCompra),HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<DetalleCompra> actualizarDetalleCompra(@RequestBody DetalleCompra detalleCompra){
        DetalleCompra updatedDetalleCompra = detalleCompraService.actualizar(detalleCompra);
        if (updatedDetalleCompra != null){
            return new ResponseEntity<DetalleCompra>(updatedDetalleCompra, HttpStatus.OK);
        }else {
            return new ResponseEntity<DetalleCompra>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalleCompra(@PathVariable("id") Long idDetalleCompra){
        detalleCompraService.eliminar(idDetalleCompra);
        return ResponseEntity.ok().build();
    }
}
