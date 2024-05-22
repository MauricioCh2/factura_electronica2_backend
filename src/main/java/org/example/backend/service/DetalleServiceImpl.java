package org.example.backend.service;

import org.example.backend.data.DetalleRepository;
import org.example.backend.logic.DetalleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleServiceImpl implements DetalleService{

    @Autowired
    private DetalleRepository detalleRepo;
    @Override
    public DetalleEntity guardar(DetalleEntity detalle) {
        return detalleRepo.save(detalle);
    }

}
