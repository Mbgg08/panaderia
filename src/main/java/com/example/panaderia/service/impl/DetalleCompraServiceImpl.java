package com.example.panaderia.service.impl;


import com.example.panaderia.Repository.DetalleCompraRepository;
import com.example.panaderia.models.DetalleCompra;
import com.example.panaderia.service.DetalleCompraService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {
    private final DetalleCompraRepository detalleCompraRepository;

    public DetalleCompraServiceImpl(DetalleCompraRepository detalleCompraRepository){
        this.detalleCompraRepository = detalleCompraRepository;
    }
    @Override
    public DetalleCompra crear(DetalleCompra obj) {
        return detalleCompraRepository.save(obj);
    }

    @Override
    public List<DetalleCompra> listar() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public DetalleCompra actualizar(DetalleCompra obj) {
        DetalleCompra objToUpdate = detalleCompraRepository.findById(obj.getDetalleCompraId()).orElse(null);
        if (objToUpdate != null) {
            objToUpdate.setProductoId(obj.getProductoId());
            objToUpdate.setClienteId(obj.getClienteId());
            objToUpdate.setEmpleadoId(obj.getEmpleadoId());
            objToUpdate.setComprobanteId(obj.getComprobanteId());
            return detalleCompraRepository.save(objToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Long id) {
        detalleCompraRepository.deleteById(id);
    }
}
