package org.example.backend.service;

import org.example.backend.data.UsuarioRepository;
import org.example.backend.logic.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements  UsuarioService{
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public List<UsuarioEntity> lisarTodos() {
        return usuarioRepo.findAll();
    }

    @Override
    public List<UsuarioEntity> lisarProvedores() {
        return usuarioRepo.findByTipo("PRO");
    }

    @Override
    public UsuarioEntity guardar(UsuarioEntity usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public UsuarioEntity buscarPorId(String id) {
        return usuarioRepo.findById(id).orElse(null);
        //() -> new RuntimeException("Usuario no encontrado para el id: " + id)
    }

    @Override
    public void eliminarUsuario(UsuarioEntity empleado) {
        usuarioRepo.delete(empleado);
    }
}
