package com.studyflow.studyflow_backend.task.repository;

import com.studyflow.studyflow_backend.task.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long>, JpaSpecificationExecutor<Task> {

    Page<Task> findAllByDeletedFalse(Pageable pageable);

    Optional<Task> findByIdAndDeletedFalse(Long id);

}
