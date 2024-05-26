package org.example.backend.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "detalles", schema = "FacturaElectronica_2", catalog = "")
public class DetalleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_detalle")
    private int idDetalle;
    @Basic
    @Column(name = "num_detalle")
    private int numDetalle;
    @Basic
    @Column(name = "id_fac_detalle")
    private int idFacDetalle;
    @Basic
    @Column(name = "codigo_producto")
    private int codigoProducto;
    @Basic
    @Column(name = "cantidad")
    private int cantidad;
    @Basic
    @Column(name = "descripcion_detalle")
    private String descripcionDetalle;
    @Basic
    @Column(name = "valor_productos")
    private double valorProductos;

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getNumDetalle() {
        return numDetalle;
    }

    public void setNumDetalle(int numDetalle) {
        this.numDetalle = numDetalle;
    }

    public int getIdFacDetalle() {
        return idFacDetalle;
    }

    public void setIdFacDetalle(int idFacDetalle) {
        this.idFacDetalle = idFacDetalle;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcionDetalle() {
        return descripcionDetalle;
    }

    public void setDescripcionDetalle(String descripcionDetalle) {
        this.descripcionDetalle = descripcionDetalle;
    }

    public double getValorProductos() {
        return valorProductos;
    }

    public void setValorProductos(double valorRoductos) {
        this.valorProductos = valorRoductos;
    }

    public DetalleEntity() {

    }

    public DetalleEntity(int idDetalle, int numDetalle, int idFacDetalle, int codigoProducto, int cantidad, String descripcionDetalle, double valorRoductos) {
        this.idDetalle = idDetalle;
        this.numDetalle = numDetalle;
        this.idFacDetalle = idFacDetalle;
        this.codigoProducto = codigoProducto;
        this.cantidad = cantidad;
        this.descripcionDetalle = descripcionDetalle;
        this.valorProductos = valorRoductos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalleEntity that = (DetalleEntity) o;
        return idDetalle == that.idDetalle && numDetalle == that.numDetalle && idFacDetalle == that.idFacDetalle && codigoProducto == that.codigoProducto && cantidad == that.cantidad && Double.compare(valorProductos, that.valorProductos) == 0 && Objects.equals(descripcionDetalle, that.descripcionDetalle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDetalle, numDetalle, idFacDetalle, codigoProducto, cantidad, descripcionDetalle, valorProductos);
    }
}
