package org.example.backend.controller;

import org.example.backend.logic.ClienteEntity;
import org.example.backend.service.ClienteService;
import org.example.backend.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/factura-electronica/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteController {
    @Autowired
     ClienteService clienteService;

 @GetMapping("/clientes")
public Iterable<ClienteEntity> listarClientes() {
        return clienteService.clienteFindAll();
    }

    @GetMapping("/clientes/{id}")
    public Iterable<ClienteEntity> listarClientesPorProveedor(@PathVariable String id) {
        return clienteService.clienteFindAllByProveedorId(id);
    }

    @PostMapping("/clientes")
    public void guardarCliente(@RequestBody ClienteEntity cliente) {
         clienteService.clienteSave(cliente);
    }
    @GetMapping("/clientes/findById/{id}")
    public ClienteEntity getClienteById (@PathVariable int id) {
        return clienteService.clienteFindById(id);
    }

}
