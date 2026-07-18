package com.studyflow.studyflow_backend.academicperiod.entity;

import com.studyflow.studyflow_backend.common.enums.AcademicPeriodType;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "academic_periods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Academic period name is required.")
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String name;

    @NotNull(message = "Academic period type is required.")
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicPeriodType type;

    @NotNull(message = "Year is required.")
    @Column(nullable = false)
    private Integer year;

    @NotNull(message = "Start Date is required.")
    @Column(nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date is required.")
    @Column(nullable = false)
    private LocalDate endDate;

    @NotNull
    @Column(nullable = false)
    private Boolean active = true;

}
