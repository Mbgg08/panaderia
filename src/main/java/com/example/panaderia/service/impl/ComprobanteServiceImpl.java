package com.example.panaderia.service.impl;
import com.example.panaderia.Repository.ComprobanteRepository;
import com.example.panaderia.models.Comprobante;
import com.example.panaderia.service.ComprobanteService;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ComprobanteServiceImpl implements ComprobanteService {
    private final ComprobanteRepository comprobanteRepository;

    public ComprobanteServiceImpl(ComprobanteRepository comprobanteRepository){
        this.comprobanteRepository = comprobanteRepository;
    }
    @Override
    public Comprobante crear(Comprobante obj) {
        return comprobanteRepository.save(obj);
    }

    @Override
    public List<Comprobante> listar() {
        return comprobanteRepository.findAll();
    }

    @Override
    public Comprobante actualizar(Comprobante obj) {
        Comprobante objToUpdate = comprobanteRepository.findById(obj.getComprobanteId()).orElse(null);
        if (objToUpdate != null) {
            objToUpdate.setClienteId(obj.getClienteId());
            objToUpdate.setEmpleadoId(obj.getEmpleadoId());
            objToUpdate.setMontoTotal(obj.getMontoTotal());
            return comprobanteRepository.save(objToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Long id) {
        comprobanteRepository.deleteById(id);
    }
}
