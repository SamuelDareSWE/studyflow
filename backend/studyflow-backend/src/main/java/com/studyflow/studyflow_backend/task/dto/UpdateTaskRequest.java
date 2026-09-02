package com.studyflow.studyflow_backend.task.dto;

import com.studyflow.studyflow_backend.common.enums.RecurrenceType;
import com.studyflow.studyflow_backend.common.enums.TaskPriority;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record UpdateTaskRequest(
        @NotBlank(message = "Task title is required.")
        @Size(max = 150, message = "Task title must not exceed 150 characters.")
        String title,

        @Size(max = 1000, message = "Task description must not exceed 1000 characters.")
        String description,

        @NotNull(message = "Task priority is required.")
        TaskPriority priority,

        @NotNull(message = "Task deadline is required.")
        LocalDateTime deadline,

        @NotNull(message = "Estimated time is required.")
        @Positive(message = "Estimated time must be greater than zero.")
        Integer estimatedTime,

        @NotNull(message = "Recurrence type is required.")
        RecurrenceType recurrence
) {
}
