package com.junior.taskapp.service;

import com.junior.taskapp.dto.CategoryDTO;
import com.junior.taskapp.entities.Category;
import com.junior.taskapp.entities.mapper.BaseMapper;
import com.junior.taskapp.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceCategory extends BaseService<Category, CategoryDTO> {

    public ServiceCategory(BaseRepository<Category> repository, BaseMapper<Category, CategoryDTO> mapper) {
        super(repository, mapper);
    }

}
