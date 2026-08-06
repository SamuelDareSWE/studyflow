package com.studyflow.studyflow_backend.course.controller;

import com.studyflow.studyflow_backend.course.dto.CourseResponse;
import com.studyflow.studyflow_backend.course.dto.CreateCourseRequest;
import com.studyflow.studyflow_backend.course.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {

    private final CourseService courseService;

    // This is created course endpoint
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CourseResponse createCourse(
            @Valid @RequestBody
            CreateCourseRequest request) {

        return courseService.createCourse(request);

    }

// This gets one course by ID
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse getCourseById(@PathVariable Long id) {

        return courseService.getCourseById(id);

    }

// This is get all courses endpoint
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<CourseResponse> getAllCourses(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = "id")
            Pageable pageable) {

        return courseService.getAllCourses(pageable);

    }

    // This is updated course endpoint
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CourseResponse updateCourse(@PathVariable Long id,
            @Valid @RequestBody
            CreateCourseRequest request) {

        return courseService.updateCourse(id, request);
    }

    // This is the soft delete endpoint
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long id) {

        courseService.deleteCourse(id);

    }

}
