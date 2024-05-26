package org.example.backend.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "proveedorActividad", schema = "FacturaElectronica_2", catalog = "")
public class ProveedorActividadEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproveedoractividad")
    private int idproveedoractividad;
    @Basic
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic
    @Column(name = "id_actividad")
    private String idActividad;

    public int getIdproveedoractividad() {
        return idproveedoractividad;
    }

    public void setIdproveedoractividad(int idproveedoractividad) {
        this.idproveedoractividad = idproveedoractividad;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(String idActividad) {
        this.idActividad = idActividad;
    }

    public ProveedorActividadEntity(String idUsuario, String idActividad) {
        this.idUsuario = idUsuario;
        this.idActividad = idActividad;
    }

    public ProveedorActividadEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProveedorActividadEntity that = (ProveedorActividadEntity) o;
        return idproveedoractividad == that.idproveedoractividad && Objects.equals(idUsuario, that.idUsuario) && Objects.equals(idActividad, that.idActividad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idproveedoractividad, idUsuario, idActividad);
    }
}
