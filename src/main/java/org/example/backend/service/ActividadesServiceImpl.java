package org.example.backend.service;

import org.example.backend.data.ActividadRepository;
import org.example.backend.data.ProveedorActividadRepository;
import org.example.backend.logic.ActividadEntity;
import org.example.backend.logic.ProveedorActividadEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadesServiceImpl implements ActividadesService{

    @Autowired
    private ActividadRepository actividadRepository;
    @Autowired
    private ProveedorActividadRepository proveedorActividadRepository;


    @Override
    public List<ActividadEntity> getListaActividades() {
        return actividadRepository.findAll();
    }

    @Override
    public ActividadEntity searchByID(int id) {
        return actividadRepository.findById(id).orElse(null);
    }

    @Override
    public List<ProveedorActividadEntity> getProveedorActivid(String id) {
        return proveedorActividadRepository.findProveedorActividadEntityByIdUsuario(id);
    }

    @Override
    public List<ActividadEntity> getActividadesAso(String id) {
        return null;
        
    }
}
