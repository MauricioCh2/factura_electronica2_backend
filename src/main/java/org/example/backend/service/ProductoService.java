package org.example.backend.service;

import org.example.backend.logic.ProductosEntity;

public interface ProductoService {
    public Iterable<ProductosEntity> productoFindAll();
    public Iterable<ProductosEntity> productoFindAllByProveedorId(String id);
    void productoSave(ProductosEntity producto);
}
