package com.example.panaderia.service;

import com.example.panaderia.models.Insumo;

import java.util.List;

public interface InsumoService {

    Insumo crear(Insumo insumo);

    List<Insumo> listar();

    Insumo actualizar(Insumo insumo);

    void eliminar(Long id);
}
