package org.example.backend.logic;

import jakarta.persistence.*;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuarios", schema = "FacturaElectronica_2")
public class UsuarioEntity {
    @Id
    @Column(name = "id_usuario")
    private String idUsuario;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "contrasenia")
    private String contrasenia;
    @Basic
    @Column(name = "tipo")
    private String tipo;
    @Basic
    @Column(name = "tipo_cedula")
    private String tipoCedula;
    @Basic
    @Column(name = "aprobado")
    private String aprobado;

    @OneToMany
    @JoinTable(
            name = "proveedorActividad", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "id_usuario"), // Columna que referencia a UsuarioEntity
            inverseJoinColumns = @JoinColumn(name = "id_actividad") // Columna que referencia a ActividadEntity
    )
    private List<ActividadEntity> actividades;


    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }




    public List<ActividadEntity> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadEntity> actividades) {
        this.actividades = actividades;
    }


    public UsuarioEntity() {
        this.actividades = new ArrayList<>();
    }

    public UsuarioEntity(String idUsuario, String nombre, String contrasenia, String tipo, String tipoCedula, String aprobado) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
        this.tipoCedula = tipoCedula;
        this.aprobado = aprobado;
        this.actividades = new ArrayList<>();
    }

    public UsuarioEntity(String idUsuario, String nombre, String tipoCedula) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.tipoCedula = tipoCedula;
        this.actividades = new ArrayList<>();
    }

    public void addActividad(ActividadEntity actividad) {
        this.actividades.add(actividad);
    }

    public void removeActividad(ActividadEntity actividad) {
        this.actividades.remove(actividad);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return aprobado == that.aprobado && Objects.equals(idUsuario, that.idUsuario) && Objects.equals(nombre, that.nombre) && Objects.equals(contrasenia, that.contrasenia) && Objects.equals(tipo, that.tipo) && Objects.equals(tipoCedula, that.tipoCedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, nombre, contrasenia, tipo, tipoCedula, aprobado);
    }
}
