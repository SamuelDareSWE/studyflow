package com.studyflow.studyflow_backend.task.service;

import com.studyflow.studyflow_backend.course.entity.Course;
import com.studyflow.studyflow_backend.task.dto.CreateTaskRequest;
import com.studyflow.studyflow_backend.task.dto.TaskResponse;
import com.studyflow.studyflow_backend.task.dto.UpdateTaskRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {

    TaskResponse createTask(CreateTaskRequest request);

    TaskResponse getTaskById(Long id);

    Page<TaskResponse> getAllTasks(Pageable pageable);

    TaskResponse updateTask(Long id, UpdateTaskRequest request);

    void deleteTask(Long id);
}
