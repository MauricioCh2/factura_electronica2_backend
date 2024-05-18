package org.example.backend.service;

import org.example.backend.logic.UsuarioEntity;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UsuarioService {
    public List<UsuarioEntity> lisarTodos();
    public List<UsuarioEntity> lisarProvedores();

    UsuarioEntity guardar(UsuarioEntity usuario);

    UsuarioEntity buscarPorId(String id);

    void eliminarUsuario(UsuarioEntity empleado);
}
