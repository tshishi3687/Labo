package com.example.Labo.business.mapper;

public interface Mapper<DTO, ENTITY> {
    DTO toDTO(ENTITY entity);
    ENTITY toEntity(DTO dto);
}
