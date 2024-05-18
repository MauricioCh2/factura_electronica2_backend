package org.example.backend.logic;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "clientes", schema = "FacturaElectronica_2", catalog = "")
public class ClienteEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_cliente")
    private int idCliente;
    @Basic
    @Column(name = "identificacion_c")
    private String identificacionC;
    @Basic
    @Column(name = "nombre_c")
    private String nombreC;
    @Basic
    @Column(name = "correo")
    private String correo;
    @Basic
    @Column(name = "telefono")
    private int telefono;
    @Basic
    @Column(name = "proveedor_c")
    private String proveedorC;

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdentificacionC() {
        return identificacionC;
    }

    public void setIdentificacionC(String identificacionC) {
        this.identificacionC = identificacionC;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getProveedorC() {
        return proveedorC;
    }

    public void setProveedorC(String proveedorC) {
        this.proveedorC = proveedorC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteEntity that = (ClienteEntity) o;
        return idCliente == that.idCliente && telefono == that.telefono && Objects.equals(identificacionC, that.identificacionC) && Objects.equals(nombreC, that.nombreC) && Objects.equals(correo, that.correo) && Objects.equals(proveedorC, that.proveedorC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, identificacionC, nombreC, correo, telefono, proveedorC);
    }
}
