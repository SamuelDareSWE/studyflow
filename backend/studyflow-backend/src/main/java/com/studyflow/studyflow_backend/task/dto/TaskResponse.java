package com.studyflow.studyflow_backend.task.dto;

import com.studyflow.studyflow_backend.common.enums.RecurrenceType;
import com.studyflow.studyflow_backend.common.enums.TaskPriority;

import java.time.LocalDateTime;

public record TaskResponse(
        Long id,
        String title,
        String description,
        TaskPriority priority,
        LocalDateTime deadline,
        Integer estimatedTime,
        RecurrenceType recurrence,
        Boolean completed,
        Boolean active,
        Long courseId,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
