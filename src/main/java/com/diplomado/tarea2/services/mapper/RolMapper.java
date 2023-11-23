package com.diplomado.tarea2.services.mapper;

import com.diplomado.tarea2.domain.entities.Rol;
import com.diplomado.tarea2.dto.RolDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol> {

    @Override
    public RolDTO toDto(Rol rol) {
        RolDTO rolDTO= new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());
        return rolDTO;
    }

    @Override
    public Rol toEntity(RolDTO rolDTO) {
        Rol rol=new Rol();
        rol.setId(rolDTO.getId());
        rol.setName(rolDTO.getName());
        return rol;
    }
}
