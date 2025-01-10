package com.junior.taskapp.controller;

import com.junior.taskapp.dto.TaskDTO;
import com.junior.taskapp.service.ServiceTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/task")
public class ControllerTask {

    @Autowired
    private ServiceTask serviceTask;

    @GetMapping
    public ResponseEntity<Page<TaskDTO>> getAllTasks(Pageable pageable) {
        Page<TaskDTO> tasks = serviceTask.getAllTasks(pageable);
        return ResponseEntity.ok(tasks);
    }


    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getById(@PathVariable Long id) {
        TaskDTO task = serviceTask.findById(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
