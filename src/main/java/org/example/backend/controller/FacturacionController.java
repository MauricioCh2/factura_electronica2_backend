package org.example.backend.controller;

import org.example.backend.logic.FacturaEntity;
import org.example.backend.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/factura-electronica/")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturacionController {
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/facturas/{userId}")
    public List<FacturaEntity> getFacturasByUser(@PathVariable String userId) {
        return facturaService.findAllByProveedor(userId);
    }

}
