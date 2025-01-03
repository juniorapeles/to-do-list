package com.junior.taskapp.service;

import com.junior.taskapp.dto.TaskDTO;
import com.junior.taskapp.entities.Task;
import com.junior.taskapp.repository.TaskRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceTask {

    private final TaskRepository taskRepository;

    public ServiceTask(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public TaskDTO findById(long id) {
        Optional<Task> entity = taskRepository.findById(id);
        return entity.map(task -> new TaskDTO(task.getId(), task.getTitle(), task.getDescription()))
                .orElse(null);
    }

    public TaskDTO createTask(TaskDTO taskDTO) {
        Task task = new Task();
        BeanUtils.copyProperties(taskDTO, task);
       taskRepository.save(task);
       return new TaskDTO(task.getId(), task.getTitle(), task.getDescription());
    }

    public List<TaskDTO> getAllTasks() {
        List<Task> entities = taskRepository.findAll();
        return entities.stream()
                .map(task -> new TaskDTO(task.getId(), task.getTitle(), task.getDescription()))
                .collect(Collectors.toList());
    }

    public TaskDTO updateTaskById(TaskDTO dto) {
        Optional<Task> entityOptional = taskRepository.findById(dto.id());
        if (entityOptional.isPresent()) {
            Task entity = entityOptional.get();
            entity.setTitle(dto.title());
            entity.setDescription(dto.description());
            taskRepository.save(entity);
            return new TaskDTO(entity.getId(), entity.getTitle(), entity.getDescription());
        }
        return null;
    }

    public void deleteTaskById(long id) {
        taskRepository.deleteById(id);
    }
}
