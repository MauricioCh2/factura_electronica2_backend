package org.example.backend.service;

import org.example.backend.data.ClienteRepository;
import org.example.backend.logic.ClienteEntity;
import org.example.backend.logic.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<ClienteEntity> clienteFindAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Iterable<ClienteEntity> clienteFindAllByProveedorId(String id) {
        return clienteRepository.findClienteEntityByProveedorC(id);
    }

    @Override
    public ClienteEntity clienteSave(ClienteEntity cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Boolean existsByIdentificacionCAndProveedorC(String idCliente, String idProveedor) {
        return clienteRepository.existsByIdentificacionCAndProveedorC(idCliente, idProveedor);
    }
}
