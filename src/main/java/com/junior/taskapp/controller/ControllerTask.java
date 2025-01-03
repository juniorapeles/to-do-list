package com.junior.taskapp.controller;

import com.junior.taskapp.dto.TaskDTO;
import com.junior.taskapp.service.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/task")
public class ControllerTask {

    @Autowired
    private ServiceTask serviceTask;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getById(@PathVariable Long id) {
        TaskDTO task = serviceTask.findById(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        List<TaskDTO> tasks = serviceTask.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO dto) {
        TaskDTO createdTask = serviceTask.createTask(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    @PutMapping
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO dto) {
        TaskDTO updatedTask = serviceTask.updateTaskById(dto);
        if (updatedTask != null) {
            return ResponseEntity.ok(updatedTask);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        serviceTask.deleteTaskById(id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
