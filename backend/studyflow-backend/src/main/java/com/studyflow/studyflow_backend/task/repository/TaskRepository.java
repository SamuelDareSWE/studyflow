package com.studyflow.studyflow_backend.task.repository;

import com.studyflow.studyflow_backend.task.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findAllByDeletedFalse(Pageable pageable);

    Optional<Task> findByIdAndDeletedFalse(Long id);

}
