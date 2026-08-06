package com.studyflow.studyflow_backend.course.mapper;

import com.studyflow.studyflow_backend.course.dto.CourseResponse;
import com.studyflow.studyflow_backend.course.dto.CreateCourseRequest;
import com.studyflow.studyflow_backend.course.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CreateCourseRequest request) {
        if (request == null) {
            return null;
        }

        Course entity = new Course();

        entity.setCourseName(request.getCourseName());
        entity.setCourseCode(request.getCourseCode());
        entity.setLecturerName((request.getLecturerName()));

        return entity;

    }

    public CourseResponse toResponse(Course entity) {

        if (entity == null) {
            return null;
        }

        CourseResponse response = new CourseResponse();

        response.setId(entity.getId());
        response.setCourseName(entity.getCourseName());
        response.setCourseCode(entity.getCourseCode());
        response.setLecturerName(entity.getLecturerName());

        if (entity.getAcademicPeriod() != null) {
            response.setAcademicPeriodId(
                    entity.getAcademicPeriod().getId()
            );
        }

        response.setActive(entity.getActive());

        return response;

    }

    public void updateEntity(
            Course entity,
            CreateCourseRequest request) {
        if (entity == null || request == null) {
            return;
        }

        entity.setCourseName(request.getCourseName());
        entity.setCourseCode(request.getCourseCode());
        entity.setLecturerName(request.getLecturerName());

    }

}
