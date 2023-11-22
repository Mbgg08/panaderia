package com.example.panaderia.service;



import com.example.panaderia.models.Producto;

import java.util.List;

public interface ProductoService {
    Producto crear(Producto producto);

    List<Producto> listar();

    Producto actualizar(Producto producto);

    void eliminar(Long id);
}
