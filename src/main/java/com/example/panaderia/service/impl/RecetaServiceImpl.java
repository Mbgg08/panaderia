package com.example.panaderia.service.impl;

import com.example.panaderia.Repository.RecetaRepository;
import com.example.panaderia.models.Receta;
import com.example.panaderia.service.RecetaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService {
    private final RecetaRepository recetaRepository;

    public RecetaServiceImpl(RecetaRepository recetaRepository){
        this.recetaRepository = recetaRepository;
    }
    @Override
    public Receta crear(Receta obj) {
        return recetaRepository.save(obj);
    }

    @Override
    public List<Receta> listar() {
        return recetaRepository.findAll();
    }

    @Override
    public Receta actualizar(Receta obj) {
        Receta objToUpdate = recetaRepository.findById(obj.getRecetaId()).orElse(null);
        if (objToUpdate != null) {
            objToUpdate.setProductoId(obj.getProductoId());
            objToUpdate.setInsumoId(obj.getInsumoId());
            return recetaRepository.save(objToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Long id) {
        recetaRepository.deleteById(id);

    }
}
