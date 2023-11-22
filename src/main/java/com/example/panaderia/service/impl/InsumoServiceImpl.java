package com.example.panaderia.service.impl;

import com.example.panaderia.Repository.InsumoRepository;
import com.example.panaderia.models.Insumo;
import com.example.panaderia.service.InsumoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class InsumoServiceImpl implements InsumoService {

    private final InsumoRepository insumoRepository;

    public InsumoServiceImpl(InsumoRepository insumoRepository){
        this.insumoRepository = insumoRepository;
    }
    @Override
    public Insumo crear(Insumo insumo) {
        return insumoRepository.save(insumo);
    }

    @Override
    public List<Insumo> listar() {
        return insumoRepository.findAll();
    }

    @Override
    public Insumo actualizar(Insumo insumo) {
        Insumo insumoToUpdate = insumoRepository.findById(insumo.getInsumoId()).orElse(null);
        if (insumoToUpdate != null) {
            insumoToUpdate.setNombreIns(insumo.getNombreIns());
            insumoToUpdate.setStockIns(insumo.getStockIns());
            insumoToUpdate.setPrecio(insumo.getPrecio());
            insumoToUpdate.setUnidad(insumo.getUnidad());
            insumoToUpdate.setMarca(insumo.getMarca());
            return insumoRepository.save(insumoToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Long id) {
        insumoRepository.deleteById(id);

    }
}
