package com.studyflow.studyflow_backend.task.service;

import com.studyflow.studyflow_backend.common.exception.ResourceNotFoundException;
import com.studyflow.studyflow_backend.course.entity.Course;
import com.studyflow.studyflow_backend.course.service.CourseService;
import com.studyflow.studyflow_backend.task.dto.CreateTaskRequest;
import com.studyflow.studyflow_backend.task.dto.TaskResponse;
import com.studyflow.studyflow_backend.task.dto.UpdateTaskRequest;
import com.studyflow.studyflow_backend.task.entity.Task;
import com.studyflow.studyflow_backend.task.mapper.TaskMapper;
import com.studyflow.studyflow_backend.task.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final CourseService courseService;


    @Override
    public TaskResponse createTask(CreateTaskRequest request) {

        Course course = courseService.findCourseEntityById(request.courseId());

        Task task = taskMapper.toEntity(request);

        task.setCourse(course);

        Task savedTask = taskRepository.save(task);

        return taskMapper.toResponse(savedTask);
    }

    @Override
    public TaskResponse getTaskById(Long id) {

        Task task = findTaskById(id);

        return taskMapper.toResponse(task);
    }

    @Override
    public Page<TaskResponse> getAllTasks(Pageable pageable) {

        return taskRepository.findAllByDeletedFalse(pageable)
                .map(taskMapper::toResponse);

    }

    @Override
    public TaskResponse updateTask(Long id, UpdateTaskRequest request) {

        Task task = findTaskById(id);

        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setPriority(request.priority());
        task.setDeadline(request.deadline());
        task.setEstimatedTime(request.estimatedTime());
        task.setRecurrence(request.recurrence());

        Task updatedTask = taskRepository.save(task);

        return taskMapper.toResponse(updatedTask);
    }

    @Override
    public void deleteTask(Long id) {

        Task task = findTaskById(id);

        task.setDeleted(true);
        task.setActive(false);

        taskRepository.save(task);

    }

    @Override
    public TaskResponse completeTask(Long id) {

        Task task = findTaskById(id);

        task.setCompleted(true);

        Task completedTask = taskRepository.save(task);

        return taskMapper.toResponse(completedTask);

    }

    private Task findTaskById(Long id) {

        return taskRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Task not found with id: " + id));

    }
}
