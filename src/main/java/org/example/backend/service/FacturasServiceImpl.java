package org.example.backend.service;

import org.example.backend.data.FacturaRepository;
import org.example.backend.logic.FacturaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacturasServiceImpl implements FacturaService{
    @Autowired
    private FacturaRepository facturaRepo;

    @Override
    public FacturaEntity save(FacturaEntity factura) {
        return facturaRepo.save(factura);
    }

    @Override
    public List<FacturaEntity> findAllByProveedor(String id) {
        return facturaRepo.findAllByIdentificacionUsuario(id);
    }

    @Override
    public Optional<FacturaEntity> findById(int id) {
        return facturaRepo.findById(id);
    }
}
