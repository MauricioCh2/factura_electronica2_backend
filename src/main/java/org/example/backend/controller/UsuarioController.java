package org.example.backend.controller;

import org.example.backend.logic.UsuarioEntity;
import org.example.backend.service.UsuarioService;
import org.example.backend.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/factura-electronica/")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {
    @Autowired
    private UsuarioService service;
    @Autowired
    private SimpMessagingTemplate template;
    

    @PostMapping("/usuarios/login")
    public ResponseEntity<UsuarioEntity> login(@RequestBody UsuarioEntity usuario) {
        UsuarioEntity usuarioEntity = service.buscarPorId(usuario.getIdUsuario());
        if (usuarioEntity != null && usuarioEntity.getContrasenia().equals(usuario.getContrasenia())) {
            return ResponseEntity.ok(usuarioEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/usuarios")
    public List<UsuarioEntity> listarProveedores() {
        return service.lisarProvedores();
    }

    //Guarda usuarios
    @PostMapping("/usuarios")
    public UsuarioEntity guardarProveedor(@RequestBody UsuarioEntity usuario) { //request body es para que reciba un objeto en formato JSON
        tools.print(tools.ORANGE + "usuario: " + usuario.toString() );
        return service.guardar(usuario);
    }

    //Busca Usuarios por ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioEntity> buscarPorId(@PathVariable String id) {
        UsuarioEntity usuario = service.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioEntity> actualizarProveedor(@PathVariable String id, @RequestBody UsuarioEntity usuarioDetails ) {
        UsuarioEntity usuario = service.buscarPorId(id);

        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setContrasenia(usuarioDetails.getContrasenia());
        usuario.setTipo(usuarioDetails.getTipo());
        usuario.setTipoCedula(usuarioDetails.getTipoCedula());
        usuario.setAprobado(usuarioDetails.getAprobado());

        UsuarioEntity updatedUsuario = service.guardar(usuario);
        this.template.convertAndSend("/topic/user-updated", usuario.getIdUsuario());

        return ResponseEntity.ok(usuario);
    }
    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<?> eliminarEmpleado(@PathVariable String id){
        UsuarioEntity usuario = service.buscarPorId(id);
        service.eliminarUsuario(usuario);
        Map<String, Boolean> respuesta = new HashMap<>();
        respuesta.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok().build();
    }

}
