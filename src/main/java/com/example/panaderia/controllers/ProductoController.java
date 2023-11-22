package com.example.panaderia.controllers;
import com.example.panaderia.models.Producto;
import com.example.panaderia.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;
    public ProductoController(ProductoService productoService){
        this.productoService = productoService;
    }
    @GetMapping
    public ResponseEntity<List<Producto>> listarProducto(){
        return new ResponseEntity<List<Producto>>(productoService.listar(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody Producto producto){
        return  new ResponseEntity<Producto>(productoService.crear(producto),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Producto> actualizarProducto(@RequestBody Producto producto){
        Producto updatedProducto = productoService.actualizar(producto);
        if (updatedProducto != null){
            return new ResponseEntity<Producto>(updatedProducto, HttpStatus.OK);
        }else {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable("id") Long id){
        productoService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
