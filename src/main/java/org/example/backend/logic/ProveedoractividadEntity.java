package org.example.backend.logic;

import jakarta.persistence.*;

@Entity
@Table(name = "proveedoractividad", schema = "facturaelectronica_2", catalog = "")
public class ProveedoractividadEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idproveedoractividad")
    private int idproveedoractividad;
    @Basic
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic
    @Column(name = "id_actividad",insertable=false, updatable=false)
    private String idActividad;
    @ManyToOne
    @JoinColumn(name = "id_actividad", referencedColumnName = "id_actividad")
    private ActividadEntity actividadByIdActividad;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProveedoractividadEntity that = (ProveedoractividadEntity) o;

        if (idproveedoractividad != that.idproveedoractividad) return false;
        if (idUsuario != null ? !idUsuario.equals(that.idUsuario) : that.idUsuario != null) return false;
        if (idActividad != null ? !idActividad.equals(that.idActividad) : that.idActividad != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idproveedoractividad;
        result = 31 * result + (idUsuario != null ? idUsuario.hashCode() : 0);
        result = 31 * result + (idActividad != null ? idActividad.hashCode() : 0);
        return result;
    }

    public ActividadEntity getActividadByIdActividad() {
        return actividadByIdActividad;
    }

    public void setActividadByIdActividad(ActividadEntity actividadByIdActividad) {
        this.actividadByIdActividad = actividadByIdActividad;
    }
}
