package org.example.backend.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "actividad", schema = "FacturaElectronica_2", catalog = "")
public class ActividadEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_actividad")
    private int idActividad;
    @Basic
    @Column(name = "descripcion")
    private String descripcion;


    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ActividadEntity(int idActividad, String descripcion) {
        this.idActividad = idActividad;
        this.descripcion = descripcion;
    }

    public ActividadEntity() {
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActividadEntity that = (ActividadEntity) o;
        return idActividad == that.idActividad && Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idActividad, descripcion);
    }
}
