package com.junior.taskapp.entities.mapper;

import com.junior.taskapp.dto.CategoryDTO;
import com.junior.taskapp.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDTO toDTO(Category category);
    Category toEntity(CategoryDTO dto);
}
