package com.junior.taskapp.service;

import com.junior.taskapp.dto.BaseDTO;
import com.junior.taskapp.entities.BaseEntity;
import com.junior.taskapp.entities.mapper.BaseMapper;
import com.junior.taskapp.repository.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

public abstract class BaseService<T extends BaseEntity, D extends BaseDTO> {

    private final BaseRepository<T> repository;
    private final BaseMapper<T, D> mapper;

    @Autowired
    public BaseService(BaseRepository<T> repository, BaseMapper<T, D> mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Método para salvar um novo registro
    public D save(D dto) {
        T entity = mapper.toEntity(dto);
        T savedEntity = repository.save(entity);
        return mapper.toDto(savedEntity);
    }

    // Método para buscar por id
    public Optional<D> findById(Long id) {
        Optional<T> entity = repository.findById(id);
        return entity.map(mapper::toDto);
    }

    // Método para buscar todos os registros
    public List<D> findAll() {
        List<T> entities = repository.findAll();
        return mapper.toDtoList(entities);
    }

    // Método para deletar um registro
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Entity with id " + id + " does not exist.");
        }
    }

    // Método para verificar se o registro existe
    public boolean exists(Long id) {
        return repository.existsById(id);
    }

    // Método para atualizar um registro existente
    public D update(Long id, D dto) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Entity with id " + id + " does not exist.");
        }

        T entity = mapper.toEntity(dto);
        entity.setId(id);  // Garantir que o id do entity seja o correto
        T updatedEntity = repository.save(entity);
        return mapper.toDto(updatedEntity);
    }
}
