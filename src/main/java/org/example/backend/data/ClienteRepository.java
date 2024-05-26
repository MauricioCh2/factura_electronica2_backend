package org.example.backend.data;

import org.example.backend.logic.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
   Iterable<ClienteEntity> findClienteEntityByProveedorC(String id);
   Boolean existsByIdentificacionCAndProveedorC(String idCliente, String idProveedor);
   ClienteEntity findClienteEntityByIdCliente(int idCliente);
}
