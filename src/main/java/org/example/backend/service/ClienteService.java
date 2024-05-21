package org.example.backend.service;

import org.example.backend.logic.ClienteEntity;
import org.example.backend.logic.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ClienteService {
    public Iterable<ClienteEntity> clienteFindAll();
    public Iterable<ClienteEntity> clienteFindAllByProveedorId(String id);
    ClienteEntity clienteSave(ClienteEntity cliente);
    public   Boolean existsByIdentificacionCAndProveedorC(String idCliente, String idProveedor);
}
