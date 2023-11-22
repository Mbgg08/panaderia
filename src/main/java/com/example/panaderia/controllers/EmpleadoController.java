package com.example.panaderia.controllers;

import com.example.panaderia.models.Empleado;
import com.example.panaderia.service.EmpleadoService;
import com.example.panaderia.service.impl.EmpleadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public ResponseEntity<List<Empleado>> listarEmpleado(){
        return new ResponseEntity<List<Empleado>>(empleadoService.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empleado> agregarEmpleado(@RequestBody Empleado empleado){
        return  new ResponseEntity<Empleado>(empleadoService.crear(empleado),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Empleado> actualizarEmpleado(@RequestBody Empleado empleado){
        Empleado updatedEmpleado = empleadoService.actualizar(empleado);
        if (updatedEmpleado != null){
            return new ResponseEntity<Empleado>(updatedEmpleado, HttpStatus.OK);
        }else {
            return new ResponseEntity<Empleado>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable("id") Long idEmpleado){
        empleadoService.eliminar(idEmpleado);
        return ResponseEntity.ok().build();
    }
}
