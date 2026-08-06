package com.studyflow.studyflow_backend.course.service;

import com.studyflow.studyflow_backend.course.dto.CourseResponse;
import com.studyflow.studyflow_backend.course.dto.CreateCourseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    CourseResponse createCourse(CreateCourseRequest request);

    CourseResponse getCourseById(Long id);

    Page<CourseResponse> getAllCourses(Pageable pageable);

    CourseResponse updateCourse(Long id, CreateCourseRequest request);

    void deleteCourse(Long id);

}
