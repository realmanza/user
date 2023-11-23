package com.diplomado.tarea2.services.mapper;
public interface CustomMapper <DTO, E>{
    DTO toDto(E e);
    E toEntity(DTO dto);
}
