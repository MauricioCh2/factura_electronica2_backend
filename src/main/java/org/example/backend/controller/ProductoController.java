package org.example.backend.controller;

import org.example.backend.logic.ProductosEntity;
import org.example.backend.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/factura-electronica/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {
    @Autowired
    ProductoService productoService;


    @GetMapping("productos/{id}")
    public Iterable<ProductosEntity> listarProductosPorProveedor(@PathVariable String id) {
        return productoService.productoFindAllByProveedorId(id);
        }

    @PostMapping("/productos")
    public void guardarProducto(@RequestBody ProductosEntity producto) { productoService.productoSave(producto);}

}
