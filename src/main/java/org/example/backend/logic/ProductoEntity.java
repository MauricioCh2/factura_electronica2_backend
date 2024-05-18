package org.example.backend.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "productos", schema = "FacturaElectronica_2", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_producto")
    private int idProducto;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "codigo")
    private String codigo;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @Basic
    @Column(name = "precio")
    private double precio;
    @Basic
    @Column(name = "proveedor_p")
    private String proveedorP;

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getProveedorP() {
        return proveedorP;
    }

    public void setProveedorP(String proveedorP) {
        this.proveedorP = proveedorP;
    }

    public ProductoEntity() {
    }

    public ProductoEntity(int idProducto, String nombre, String codigo, String descripcion, double precio, String proveedorP) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.proveedorP = proveedorP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoEntity that = (ProductoEntity) o;
        return idProducto == that.idProducto && Double.compare(precio, that.precio) == 0 && Objects.equals(nombre, that.nombre) && Objects.equals(codigo, that.codigo) && Objects.equals(descripcion, that.descripcion) && Objects.equals(proveedorP, that.proveedorP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProducto, nombre, codigo, descripcion, precio, proveedorP);
    }
}
