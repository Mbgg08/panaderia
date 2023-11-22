package com.example.panaderia.service.impl;

import com.example.panaderia.Repository.EmpleadoRepository;
import com.example.panaderia.models.Empleado;
import com.example.panaderia.service.EmpleadoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServiceImpl implements EmpleadoService {
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado crear(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> listar() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado actualizar(Empleado empleado) {
        Empleado empleadoToUpdate = empleadoRepository.findById(empleado.getEmpleadoId()).orElse(null);
        if (empleadoToUpdate != null) {
            empleadoToUpdate.setNombreEmpleado(empleado.getNombreEmpleado());
            empleadoToUpdate.setRol(empleado.getRol());
            return empleadoRepository.save(empleadoToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Long id) {
        empleadoRepository.deleteById(id);
    }
}
