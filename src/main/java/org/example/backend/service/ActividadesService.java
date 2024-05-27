package org.example.backend.service;

import org.example.backend.logic.ActividadEntity;
import org.example.backend.logic.ProveedorActividadEntity;

import java.util.List;

public interface ActividadesService {
    List<ActividadEntity> getListaActividades();
    ActividadEntity searchByID(int id);
    List<ProveedorActividadEntity> getProveedorActivid(String id);
    List<ActividadEntity> getActividadesAso(String id);
}
