package org.example.backend.logic;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "facturas", schema = "FacturaElectronica_2", catalog = "")
public class FacturaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_factura")
    private int idFactura;
    @Basic
    @Column(name = "identificacion_usuario")
    private String identificacionUsuario;
    @Basic
    @Column(name = "identificacion_cliente")
    private int identificacionCliente;
    @Basic
    @Column(name = "valor_total")
    private double valorTotal;
    @Basic
    @Column(name = "fecha")
    private Timestamp fecha;

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public String getIdentificacionUsuario() {
        return identificacionUsuario;
    }

    public void setIdentificacionUsuario(String identificacionUsuario) {
        this.identificacionUsuario = identificacionUsuario;
    }

    public int getIdentificacionCliente() {
        return identificacionCliente;
    }

    public void setIdentificacionCliente(int identificacionCliente) {
        this.identificacionCliente = identificacionCliente;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public FacturaEntity(int idFactura, String identificacionUsuario, int identificacionCliente, double valorTotal, Timestamp fecha) {
        this.idFactura = idFactura;
        this.identificacionUsuario = identificacionUsuario;
        this.identificacionCliente = identificacionCliente;
        this.valorTotal = valorTotal;
        this.fecha = fecha;
    }

    public FacturaEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacturaEntity that = (FacturaEntity) o;
        return idFactura == that.idFactura && identificacionCliente == that.identificacionCliente && Double.compare(valorTotal, that.valorTotal) == 0 && Objects.equals(identificacionUsuario, that.identificacionUsuario) && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFactura, identificacionUsuario, identificacionCliente, valorTotal, fecha);
    }
}
