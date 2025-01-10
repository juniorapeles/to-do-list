package com.junior.taskapp.dto;

import com.junior.taskapp.entities.enums.Priority;
import com.junior.taskapp.entities.enums.Status;

public record TaskDTO(Long id, String title, String description, Status status, Priority priority) {
}
