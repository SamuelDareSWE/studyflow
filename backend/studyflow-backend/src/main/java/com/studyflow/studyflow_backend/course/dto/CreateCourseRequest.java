package com.studyflow.studyflow_backend.course.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Getter;

import lombok.Setter;

@Getter
@Setter
public class CreateCourseRequest {

    @NotBlank(message = "Course name is required.")
    @Size(max = 100)
    private String courseName;

    @NotBlank(message = "Course code is required.")
    @Size(max = 20)
    private String courseCode;

    @Size(max = 100)
    private String lecturerName;

    @NotNull(message = "Academic period is required.")
    private Long academicPeriodId;

}
