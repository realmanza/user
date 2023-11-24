package com.diplomado.tarea2.services;
import com.diplomado.tarea2.domain.entities.Rol;
import com.diplomado.tarea2.dto.RolDTO;
import com.diplomado.tarea2.dto.UserViewDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRoles();
    List<UserViewDTO> listUsersByRolId(Integer rolId);
    RolDTO save(RolDTO rolDTO);
    Optional<RolDTO> getRolById(Integer id);
    void delete(Integer id);
}
