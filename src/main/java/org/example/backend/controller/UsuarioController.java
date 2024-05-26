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
            return ResponseEntity.notFound().build();// nota esto devuelve un 404
        }
    }
    @PostMapping("/usuarios/agregarCliente/{id}")
    public ResponseEntity<ClienteEntity> agregarCliente(@PathVariable String id, @RequestBody ClienteEntity cliente) {
        tools.print(tools.ORANGE+ "Estoy en agregar cliente");
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


    @PostMapping("/usuarios")
    public ResponseEntity<?> guardarProveedor(@RequestBody UsuarioEntity usuario) {
        tools.print(tools.ORANGE+ "Estoy en agregar usuario");
        tools.print(tools.RED + service.buscarPorId(usuario.getIdUsuario()));

            if(service.buscarPorId(usuario.getIdUsuario()) == null) {//en caso de que no este en la base de datos continuara el proceso
                tools.print(tools.ORANGE+ "No esta en la  en la db");

                if (stub.verifyNewProveedor(usuario)) {//revisa si se encuentra en el STUB (hacienda)
                    tools.print(tools.ORANGE+ "Esta en el stub");
//                    return ResponseEntity.status(HttpStatus.OK).body(stub.getProveedorById(usuario.getIdUsuario()));
                    service.guardar(usuario);
                    return ResponseEntity.status(HttpStatus.OK).body(stub.getActividadesProv(usuario.getIdUsuario()));//guarda el usuario en la base de datos--------------
                }
                tools.print(tools.ORANGE+ "No esta  en el stub");

                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El proveedor NO se encuentra registrado en la lista de hacienda!!!.");


            }else{

                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("El proveedor ya se encuentra registrado en el sistema de facturación electronica.");
            }


    }

    //Busca Usuarios por ID
    @GetMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioEntity> buscarPorId(@PathVariable String id) {
        UsuarioEntity usuario = service.buscarPorId(id);
        if(usuario != null) {
            return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<UsuarioEntity> actualizarProveedor(@PathVariable String id, @RequestBody UsuarioEntity usuarioDetails ) {
        UsuarioEntity usuario = service.buscarPorId(id);

        if(usuario != null) {
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setContrasenia(usuarioDetails.getContrasenia());
        usuario.setTipo(usuarioDetails.getTipo());
        usuario.setTipoCedula(usuarioDetails.getTipoCedula());
        usuario.setAprobado(usuarioDetails.getAprobado());

        UsuarioEntity updatedUsuario = service.guardar(usuario);
        return ResponseEntity.ok(usuario);
        }else {
            return ResponseEntity.notFound().build();
        }
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
