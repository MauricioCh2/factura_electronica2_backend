package org.example.backend.data;


import org.example.backend.logic.FacturaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  FacturaRepository extends JpaRepository<FacturaEntity,Integer> {
    List<FacturaEntity> findAllByIdentificacionUsuario(String idproveedor);
    FacturaEntity findFacturaEntityByIdFactura(int id);
}
