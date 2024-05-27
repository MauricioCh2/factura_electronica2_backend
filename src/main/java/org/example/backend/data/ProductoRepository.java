package org.example.backend.data;

import org.example.backend.logic.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, String> {
    Iterable<ProductoEntity> findProductoEntityByProveedorP(String id);
}
