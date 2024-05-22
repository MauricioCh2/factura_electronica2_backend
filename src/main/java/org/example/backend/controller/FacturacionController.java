package org.example.backend.controller;

import org.example.backend.logic.FacturaConDetalles;
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

    @PostMapping("/facturar")
    public void facturar(@RequestBody FacturaConDetalles facturaConDetalles) {
        // Aquí puedes acceder a la factura y los detalles con facturaConDetalles.getFactura() y facturaConDetalles.getDetalles()
        FacturaEntity facturaAux = facturaConDetalles.getFactura();

        //ArrayList<DetalleEntity> detalles = (ArrayList<DetalleEntity>) facturaConDetalles.getDetalles();
        // Luego puedes procesar estos datos y guardarlos en tu base de datos

        // Finalmente, puedes devolver una respuesta. Por ejemplo, podrías devolver la factura que se acaba de crear:


        //return new ResponseEntity<>(facturaConDetalles.getFactura(), HttpStatus.CREATED);
    }
}

