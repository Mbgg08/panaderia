package com.example.panaderia.service.impl;

import com.example.panaderia.Repository.ClienteRepository;
import com.example.panaderia.models.Cliente;
import com.example.panaderia.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente crear(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente actualizar(Cliente cliente) {
        Cliente clienteToUpdate = clienteRepository.findById(cliente.getClienteId()).orElse(null);
        if (clienteToUpdate != null) {
            clienteToUpdate.setNombreCliente(cliente.getNombreCliente());
            clienteToUpdate.setDni(cliente.getDni());
            clienteToUpdate.setRuc(cliente.getRuc());
            clienteToUpdate.setTelefono(cliente.getTelefono());
            return clienteRepository.save(clienteToUpdate);
        } else {
            return null;
        }
    }

    @Override
    public void eliminar(Long id) {

        clienteRepository.deleteById(id);
    }
}
