package com.studyflow.studyflow_backend.task.mapper;

import com.studyflow.studyflow_backend.task.dto.CreateTaskRequest;
import com.studyflow.studyflow_backend.task.dto.TaskResponse;
import com.studyflow.studyflow_backend.task.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public Task toEntity(CreateTaskRequest request) {
        Task task = new Task();

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setPriority(request.priority());
        task.setDeadline(request.deadline());
        task.setEstimatedTime(request.estimatedTime());
        task.setRecurrence(request.recurrence());

        return task;
    }

    public TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getDeadline(),
                task.getEstimatedTime(),
                task.getRecurrence(),
                task.getCompleted(),
                task.getActive(),
                task.getCourse().getId(),
                task.getCreatedAt(),
                task.getUpdatedAt()
        );
    }
}
