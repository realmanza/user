package com.diplomado.tarea2.repositories;

import com.diplomado.tarea2.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol,Integer> {
}