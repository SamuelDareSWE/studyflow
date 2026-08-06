package com.studyflow.studyflow_backend.course.entity;

import com.studyflow.studyflow_backend.academicperiod.entity.AcademicPeriod;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course name is required.")
    @Column(nullable = false, length = 100)
    private String courseName;

    @NotBlank(message = "Course code is required.")
    @Column(nullable = false, length = 20)
    private String courseCode;

    @Column(length = 100)
    private String lecturerName;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "academic_period_id", nullable = false)
    private AcademicPeriod academicPeriod;

    @Column(nullable = false)
    private Boolean active;

    @Column(nullable = false)
    private Boolean deleted = false;

}
