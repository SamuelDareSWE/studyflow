package com.studyflow.studyflow_backend.task.controller;

import com.studyflow.studyflow_backend.common.enums.TaskPriority;
import com.studyflow.studyflow_backend.task.dto.CreateTaskRequest;
import com.studyflow.studyflow_backend.task.dto.TaskResponse;
import com.studyflow.studyflow_backend.task.dto.UpdateTaskRequest;
import com.studyflow.studyflow_backend.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(
            @Valid @RequestBody CreateTaskRequest request) {

        return taskService.createTask(request);

    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse getTaskById(@PathVariable Long id) {

        return taskService.getTaskById(id);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TaskResponse> getAllTasks(
            @RequestParam(required = false) Boolean completed,
            @RequestParam(required = false) TaskPriority priority,
            @RequestParam(required = false) Long courseId,
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "deadline") Pageable pageable){

        return taskService.getAllTasks(
                completed,
                priority,
                courseId,
                pageable);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse updateTask(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskRequest request) {

        return taskService.updateTask(id, request);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);

    }

    @PatchMapping("/{id}/complete")
    @ResponseStatus(HttpStatus.OK)
    public TaskResponse completeTask(@PathVariable Long id){

        return taskService.completeTask(id);

    }

}
