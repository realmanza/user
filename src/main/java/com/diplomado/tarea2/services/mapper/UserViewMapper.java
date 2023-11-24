package com.diplomado.tarea2.services.mapper;
import com.diplomado.tarea2.domain.entities.User;
import com.diplomado.tarea2.dto.UserDTO;
import com.diplomado.tarea2.dto.UserViewDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserViewMapper implements CustomMapper<UserViewDTO, User> {
    @Override
    public UserViewDTO toDto(User user) {
        UserViewDTO userDTO = new UserViewDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        return userDTO;
    }
    public UserViewDTO toDtoDetailed(User user) {
        UserViewDTO userDTO = new UserViewDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setCreatedAt(user.getCreatedAt());
        if (user.getUserDetail()!=null) {
            userDTO.setFirstName(user.getUserDetail().getFirstName());
            userDTO.setLastName(user.getUserDetail().getLastName());
            userDTO.setAge(user.getUserDetail().getAge());
            userDTO.setBirthDay(user.getUserDetail().getBirthDay());
        }
        else {
            userDTO.setFirstName("No asignado");
            userDTO.setLastName("No asignado");
            userDTO.setAge(0);
            userDTO.setBirthDay(LocalDate.now());
        }
        return userDTO;
    }

    @Override
    public User toEntity(UserViewDTO userViewDTO) {
        return null;
    }
}
