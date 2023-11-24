package com.diplomado.tarea2.services;
import com.diplomado.tarea2.dto.UserDTO;
import com.diplomado.tarea2.dto.UserViewDTO;

import java.util.List;

public interface UserService {
    List<UserViewDTO> listUsers();
    List<UserViewDTO> listUsersDetailed();
    UserDTO save(UserDTO userDTO);
    void delete(Long id);
}
