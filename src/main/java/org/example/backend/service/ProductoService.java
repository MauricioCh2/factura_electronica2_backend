package org.example.backend.service;

import org.example.backend.logic.ProductoEntity;

public interface ProductoService {
    public Iterable<ProductoEntity> productoFindAll();
    public Iterable<ProductoEntity> productoFindAllByProveedorId(String id);
    void productoSave(ProductoEntity producto);
}
