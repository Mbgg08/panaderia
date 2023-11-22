package com.example.panaderia.service;

import com.example.panaderia.models.Comprobante;
import com.example.panaderia.models.DetalleCompra;

import java.util.List;

public interface ComprobanteService {
    Comprobante crear(Comprobante obj);

    List<Comprobante> listar();

    Comprobante actualizar(Comprobante obj);

    void eliminar(Long id);
}
