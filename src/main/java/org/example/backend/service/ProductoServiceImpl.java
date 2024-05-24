package org.example.backend.service;

import org.example.backend.data.ProductoRepository;
import org.example.backend.logic.ProductosEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Iterable<ProductosEntity> productoFindAll(){ return productoRepository.findAll();}

    @Override
    public Iterable<ProductosEntity> productoFindAllByProveedorId(String id) {
        return productoRepository.findProductoEntityByProveedorP(id);
    }

    @Override
    public void productoSave(ProductosEntity producto) { productoRepository.save(producto);}
}
