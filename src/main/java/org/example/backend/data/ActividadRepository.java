package org.example.backend.data;

import org.example.backend.logic.ActividadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadRepository extends JpaRepository<ActividadEntity, Integer> {
}
