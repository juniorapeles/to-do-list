package com.junior.taskapp.entities.mapper;

@Mapper(componentModel = "spring")
public interface BaseMapper<T extends BaseEntity, D extends BaseDTO> {

    // Mapeamento de uma entidade para DTO
    D toDto(T entity);

    // Mapeamento de DTO para uma entidade
    T toEntity(D dto);

    // Mapeamento de uma lista de entidades para uma lista de DTOs
    List<D> toDtoList(List<T> entities);

    // Mapeamento de DTO para uma entidade existente (usado para atualizar)
    void updateEntityFromDto(D dto, @MappingTarget T entity);
}