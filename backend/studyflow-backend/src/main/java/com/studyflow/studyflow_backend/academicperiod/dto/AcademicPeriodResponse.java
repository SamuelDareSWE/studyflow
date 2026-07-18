package com.studyflow.studyflow_backend.academicperiod.dto;

import com.studyflow.studyflow_backend.common.enums.AcademicPeriodType;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AcademicPeriodResponse {
    private Long id;
    private String name;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer year;
    private AcademicPeriodType type;
    private Boolean active;
}
