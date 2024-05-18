package org.example.backend.service;

import org.example.backend.data.FacturaRepository;
import org.example.backend.logic.FacturaEntity;

import java.util.List;
import java.util.Optional;

public interface FacturaService {

    public FacturaEntity save(FacturaEntity factura);
    public List<FacturaEntity> findAllByProveedor(String id);
    public Optional<FacturaEntity> findById(int id);

}
