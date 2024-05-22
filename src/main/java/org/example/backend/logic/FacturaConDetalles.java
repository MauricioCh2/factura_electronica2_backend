package org.example.backend.logic;

import java.util.List;

public class FacturaConDetalles {
    private FacturaEntity factura;
    private List<DetalleEntity> detalles;

    public FacturaEntity getFactura() {
        return factura;
    }

    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    public List<DetalleEntity> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleEntity> detalles) {
        this.detalles = detalles;
    }
}