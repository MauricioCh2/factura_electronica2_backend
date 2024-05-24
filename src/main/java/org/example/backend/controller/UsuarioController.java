package org.example.backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.example.backend.data.STUB;
import org.example.backend.logic.ClienteEntity;
import org.example.backend.logic.UsuarioEntity;
import org.example.backend.service.ClienteService;
import org.example.backend.service.UsuarioService;
import org.example.backend.tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private ClienteService clienteService;
    private STUB stub = new STUB();
    @Autowired
    private HttpServletResponse httpServletResponse;

    @PostMapping("/usuarios/login")
    public ResponseEntity<UsuarioEntity> login(@RequestBody UsuarioEntity usuario) {


        UsuarioEntity usuarioEntity = service.buscarPorId(usuario.getIdUsuario());
        if (usuarioEntity != null && usuarioEntity.getContrasenia().equals(usuario.getContrasenia())) {
            return ResponseEntity.ok(usuarioEntity);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/usuarios/agregarCliente/{id}")
    public ResponseEntity<ClienteEntity> agregarCliente(@PathVariable String id, @RequestBody ClienteEntity cliente) {
        if(clienteService.existsByIdentificacionCAndProveedorC(cliente.getIdentificacionC(), id)){
            return ResponseEntity.badRequest().build();
        }
        cliente.setProveedorC(id);
        ClienteEntity clienteEntity = clienteService.clienteSave(cliente);
        return ResponseEntity.ok(clienteEntity);
    }
    @GetMapping("/usuarios")
    public List<UsuarioEntity> listarProveedores() {
        return service.lisarProvedores();
    }

//    //Guarda usuarios
//    @PostMapping("/usuarios")
//    public UsuarioEntity guardarProveedor(@RequestBody UsuarioEntity usuario) {
//        //request body es para que reciba un objeto en formato JSON
//        if(stub.verifyNewProveedor(usuario)){
//            tools.print(tools.ORANGE + "usuario: " + usuario.toString() );
//            return service.guardar(usuario);
//        }
//        // envia un mesaje de error que el proveedor ya existe
//        return null;
//    }

    @PostMapping("/usuarios")
    public ResponseEntity<?> guardarProveedor(@RequestBody UsuarioEntity usuario) {
        if (stub.verifyNewProveedor(usuario)) {
            return ResponseEntity.status(HttpStatus.OK).body(service.guardar(usuario));
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("El proveedor NO se encuentra registrado en la lista de hacienda!!!.");
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
