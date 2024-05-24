package org.example.backend.data;

import org.example.backend.logic.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductosEntity, String> {
    Iterable<ProductosEntity> findProductoEntityByProveedorP(String id);
}
