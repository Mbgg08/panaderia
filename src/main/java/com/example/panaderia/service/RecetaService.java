package com.example.panaderia.service;


import com.example.panaderia.models.Receta;

import java.util.List;

public interface RecetaService {
    Receta crear(Receta obj);

    List<Receta> listar();

    Receta actualizar(Receta obj);

    void eliminar(Long id);
}
