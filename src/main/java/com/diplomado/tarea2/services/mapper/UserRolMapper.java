package com.diplomado.tarea2.services.mapper;
import com.diplomado.tarea2.domain.entities.UserRol;
import com.diplomado.tarea2.dto.UserRolDTO;

public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol>{
    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO userRolDTO=new UserRolDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setActive(userRol.isActive());
        userRolDTO.setCreatedAt(userRol.getCreatedAt());
        return userRolDTO;
    }

    @Override
    public UserRol toEntity(UserRolDTO userRolDTO) {
        UserRol userRol=new UserRol();
        userRol.setId(userRolDTO.getId());
        userRol.setActive(userRolDTO.isActive());
        return userRol;
    }
}
