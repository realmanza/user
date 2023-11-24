package com.diplomado.tarea2.repositories.jdbc;
import com.diplomado.tarea2.dto.UserViewDTO;
import java.util.List;
public interface RolUserJdbcRepository {
    List<UserViewDTO>listUsersByRolId(Integer rolId);
}
