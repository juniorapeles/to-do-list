package com.junior.taskapp.service;

import com.junior.taskapp.dto.TaskDTO;
import com.junior.taskapp.entities.Task;
import com.junior.taskapp.repository.TaskRepository;
import org.springframework.beans.BeanUtils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ServiceTask {

    private final TaskRepository taskRepository;

    public ServiceTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO findById(long id) {
        Optional<Task> entity = taskRepository.findById(id);
        return entity.map(task -> new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority()))
                .orElse(null);
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
        taskRepository.save(task);
        return new TaskDTO(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getPriority());
    }

    public Page<TaskDTO> getAllTasks(Pageable pageable) {
        return taskRepository.findAll(pageable)
                .map(task -> new TaskDTO(task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.getStatus(),
                        task.getPriority()));
    }

    public TaskDTO updateTaskById(TaskDTO dto) {
        Optional<Task> entityOptional = taskRepository.findById(dto.id());
        if (entityOptional.isPresent()) {
            Task entity = entityOptional.get();
            entity.setTitle(dto.title());
            entity.setDescription(dto.description());
            taskRepository.save(entity);
            return new TaskDTO(entity.getId(), entity.getTitle(), entity.getDescription(), entity.getStatus(), entity.getPriority());
        }
        return null;
    }

    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }
}
