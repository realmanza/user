package com.diplomado.tarea2.repositories;

import com.diplomado.tarea2.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
