package org.example.backend.logic;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "actividad", schema = "facturaelectronica_2", catalog = "")
public class ActividadEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_actividad")
    private String idActividad;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "actividadByIdActividad")
    private Collection<ProductosEntity> productosByIdActividad;
    @OneToMany(mappedBy = "actividadByIdActividad")
    private Collection<ProveedoractividadEntity> proveedoractividadsByIdActividad;

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActividadEntity that = (ActividadEntity) o;

        if (idActividad != null ? !idActividad.equals(that.idActividad) : that.idActividad != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idActividad != null ? idActividad.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    public Collection<ProductosEntity> getProductosByIdActividad() {
        return productosByIdActividad;
    }

    public void setProductosByIdActividad(Collection<ProductosEntity> productosByIdActividad) {
        this.productosByIdActividad = productosByIdActividad;
    }

    public Collection<ProveedoractividadEntity> getProveedoractividadsByIdActividad() {
        return proveedoractividadsByIdActividad;
    }

    public void setProveedoractividadsByIdActividad(Collection<ProveedoractividadEntity> proveedoractividadsByIdActividad) {
        this.proveedoractividadsByIdActividad = proveedoractividadsByIdActividad;
    }
}
