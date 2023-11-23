package com.diplomado.tarea2.repositories;

import com.diplomado.tarea2.domain.entities.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
}
