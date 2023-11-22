package com.example.panaderia.service.impl;




import com.example.panaderia.Repository.ProductoRepository;
import com.example.panaderia.models.Producto;
import com.example.panaderia.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository){
        this.productoRepository = productoRepository;
    }
    @Override
    public Producto crear(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listar() {
        return productoRepository.findAll();
    }

    @Override
    public Producto actualizar(Producto producto) {
        Producto productoToUpdate = productoRepository.findById(producto.getProductoId()).orElse(null);
        if (productoToUpdate != null) {
            productoToUpdate.setNombreProd(producto.getNombreProd());
            productoToUpdate.setPrecio(producto.getPrecio());
            productoToUpdate.setDescripcion(producto.getDescripcion());
            productoToUpdate.setStockProd(producto.getStockProd());
            return productoRepository.save(productoToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Long id) {
        productoRepository.deleteById(id);

    }
}
