package com.studyflow.studyflow_backend.course.service;

import com.studyflow.studyflow_backend.course.dto.CourseResponse;
import com.studyflow.studyflow_backend.course.dto.CreateCourseRequest;
import com.studyflow.studyflow_backend.course.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    CourseResponse createCourse(CreateCourseRequest request);

    CourseResponse getCourseById(Long id);

    Page<CourseResponse> getAllCourses(Pageable pageable);

    CourseResponse updateCourse(Long id, CreateCourseRequest request);

    Course findCourseEntityById(Long id);

    void deleteCourse(Long id);

}
