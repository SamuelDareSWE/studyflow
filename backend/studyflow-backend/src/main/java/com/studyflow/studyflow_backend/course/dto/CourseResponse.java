package com.studyflow.studyflow_backend.course.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseResponse {

    private Long id;
    private String courseName;
    private String courseCode;
    private String lecturerName;
    private Long academicPeriodId;
    private Boolean active;

}
