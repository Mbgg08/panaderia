package com.example.panaderia.service;

import com.example.panaderia.models.Cliente;


import java.util.List;

public interface ClienteService {
    Cliente crear(Cliente cliente);

    List<Cliente> listar();

    Cliente actualizar(Cliente cliente);

    void eliminar(Long id);
}
