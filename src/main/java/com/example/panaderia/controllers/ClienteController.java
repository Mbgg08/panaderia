package com.example.panaderia.controllers;

import com.example.panaderia.models.Cliente;
import com.example.panaderia.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes(){
        return new ResponseEntity<List<Cliente>>(clienteService.listar(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cliente> agregarCliente(@RequestBody Cliente cliente){
        return  new ResponseEntity<Cliente>(clienteService.crear(cliente),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente){
        Cliente updatedCliente = clienteService.actualizar(cliente);
        if (updatedCliente != null){
            return new ResponseEntity<Cliente>(updatedCliente, HttpStatus.OK);
        }else {
            return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable("id") Long id){
        clienteService.eliminar(id);
        return ResponseEntity.ok().build();
    }
}
