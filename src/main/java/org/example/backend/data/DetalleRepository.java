package org.example.backend.data;

import org.example.backend.logic.DetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRepository extends JpaRepository<DetalleEntity,Integer> {
}
