package com.studyflow.studyflow_backend.course.service;

import com.studyflow.studyflow_backend.academicperiod.entity.AcademicPeriod;
import com.studyflow.studyflow_backend.academicperiod.repository.AcademicPeriodRepository;
import com.studyflow.studyflow_backend.common.exception.ResourceNotFoundException;
import com.studyflow.studyflow_backend.course.dto.CourseResponse;
import com.studyflow.studyflow_backend.course.dto.CreateCourseRequest;
import com.studyflow.studyflow_backend.course.entity.Course;
import com.studyflow.studyflow_backend.course.mapper.CourseMapper;
import com.studyflow.studyflow_backend.course.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    private final CourseMapper courseMapper;

    private final AcademicPeriodRepository academicPeriodRepository;

    @Override
    public CourseResponse createCourse(CreateCourseRequest request) {
        AcademicPeriod academicPeriod = academicPeriodRepository
                .findByIdAndDeletedFalse(request.getAcademicPeriodId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Academic period not found with id: "
                                + request.getAcademicPeriodId()));

        Course course = courseMapper.toEntity(request);

        course.setAcademicPeriod(academicPeriod);
        course.setActive(true);
        course.setDeleted(false);

        Course savedCourse = courseRepository.save(course);

        return courseMapper.toResponse(savedCourse);
    }

    @Override
    public CourseResponse getCourseById(Long id) {

        Course course = findCourseById(id);

        return courseMapper.toResponse(course);
    }

    @Override
    public Page<CourseResponse> getAllCourses(Pageable pageable) {

        return courseRepository.findAllByDeletedFalse(pageable)
                .map(courseMapper::toResponse);

    }

    @Override
    public CourseResponse updateCourse(Long id, CreateCourseRequest request) {

        Course existingCourse = findCourseById(id);

        AcademicPeriod academicPeriod = academicPeriodRepository
                .findByIdAndDeletedFalse(request.getAcademicPeriodId())
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Academic period not found with id: "
                                + request.getAcademicPeriodId()));

        courseMapper.updateEntity(existingCourse, request);
        existingCourse.setAcademicPeriod(academicPeriod);

        Course savedCourse = courseRepository.save(existingCourse);

        return courseMapper.toResponse(savedCourse);
    }

    public Course findCourseEntityById(Long id) {
        return findCourseById(id);
    }

    @Override
    public void deleteCourse(Long id) {

        Course course = findCourseById(id);

        course.setDeleted(true);
        course.setActive(false);

        courseRepository.save(course);

    }

    private Course findCourseById(Long id) {

        return courseRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Course not found with id: " + id));

    }

}
