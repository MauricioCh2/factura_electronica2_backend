package org.example.backend.data;

import org.example.backend.logic.UsuarioEntity;

import java.util.List;

public class STUB {
    private final List<UsuarioEntity> proveedoresAprobados;

    public STUB() {
        proveedoresAprobados = List.of(
                new UsuarioEntity("111", "pedrito", "12345678", "PRO", "FIS", "ESP"),
                new UsuarioEntity("2", "Ashly", "1", "PRO", "FIS", "APR"),
                new UsuarioEntity("4", "Mauricio", "1", "PRO", "JUR", "ESP"),
                new UsuarioEntity("5", "Jairo", "1", "PRO", "FIS", "REC"),
                new UsuarioEntity("6", "Daniel", "1", "PRO", "JUR", "REV"),
                new UsuarioEntity("7", "Andrey", "1", "PRO", "FIS", "ESP"),
                new UsuarioEntity("111", "PROV1", "PROV@V11", "PROV", "FIS", "ESP"),
                new UsuarioEntity("2222", "PROV2", "PROV@V22", "PROV", "JUR", "ESP")
        );
    }

    public Iterable<UsuarioEntity> getProveedoresAprobados() {
        return proveedoresAprobados;
    }
    public Boolean verifyNewProveedor(UsuarioEntity proveedor) {
        return proveedoresAprobados.stream().anyMatch(p ->
                p.getIdUsuario().equals(proveedor.getIdUsuario()) &&
                        p.getNombre().equals(proveedor.getNombre()) &&
                        p.getContrasenia().equals(proveedor.getContrasenia()) &&
                        p.getTipoCedula().equals(proveedor.getTipoCedula())
        );
    }
}
