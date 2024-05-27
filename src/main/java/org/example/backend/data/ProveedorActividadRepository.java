package org.example.backend.data;

import org.example.backend.logic.ProveedorActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorActividadRepository extends JpaRepository<ProveedorActividadEntity, Integer> {
    List<ProveedorActividadEntity> findProveedorActividadEntityByIdUsuario(String id);

}
