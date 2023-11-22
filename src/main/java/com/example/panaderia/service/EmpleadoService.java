package com.example.panaderia.service;

import com.example.panaderia.models.Empleado;

import java.util.List;

public interface EmpleadoService {
    Empleado crear(Empleado empleado);

    List<Empleado> listar();

    Empleado actualizar(Empleado empleado);

    void eliminar(Long id);
}
