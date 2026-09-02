package com.studyflow.studyflow_backend.task.entity;

import com.studyflow.studyflow_backend.common.enums.RecurrenceType;
import com.studyflow.studyflow_backend.common.enums.TaskPriority;
import com.studyflow.studyflow_backend.course.entity.Course;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Task title is required.")
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String title;

    @Size(max = 1000)
    @Column(length = 1000)
    private String description;

    @NotNull(message = "Task priority is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TaskPriority priority;

    @NotNull(message = "Task deadline is required.")
    @Column(nullable = false)
    private LocalDateTime deadline;

    @NotNull(message = "Estimated time is required.")
    @Positive(message = "Estimated time must be greater than zero.")
    @Column(nullable = false)
    private Integer estimatedTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RecurrenceType recurrence = RecurrenceType.NONE;

    @Column(nullable = false)
    private Boolean completed = false;

    @Column(nullable = false)
    private Boolean active = true;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @PrePersist
    protected void onCreated() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
