package com.example.panaderia.service;

import com.example.panaderia.models.DetalleCompra;
import com.example.panaderia.models.Receta;

import java.util.List;

public interface DetalleCompraService {
    DetalleCompra crear(DetalleCompra obj);

    List<DetalleCompra> listar();

    DetalleCompra actualizar(DetalleCompra obj);

    void eliminar(Long id);
}
