package org.example.backend.logic;

import java.util.List;

public class UsuarioYActividades {
    UsuarioEntity usuario;
    List<ActividadEntity> actividades;

    public UsuarioYActividades(UsuarioEntity usuario, List<ActividadEntity> actividades) {
        this.usuario = usuario;
        this.actividades = actividades;
    }
}
