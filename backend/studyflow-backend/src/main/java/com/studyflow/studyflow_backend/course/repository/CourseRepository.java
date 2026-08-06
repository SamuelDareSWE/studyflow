package com.studyflow.studyflow_backend.course.repository;

import com.studyflow.studyflow_backend.course.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findAllByDeletedFalse(Pageable pageable);

    Optional<Course> findByIdAndDeletedFalse(Long id);
}
