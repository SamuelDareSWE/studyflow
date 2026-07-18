package com.studyflow.studyflow_backend.academicperiod.dto;

import com.studyflow.studyflow_backend.common.enums.AcademicPeriodType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateAcademicPeriodRequest {

    @NotBlank(message = "Academic period name is required.")
    @Size(max = 100)
    private String name;

    @NotNull(message = "Year is required.")
    private Integer year;

    @NotNull(message = "Academic period type is required.")
    private AcademicPeriodType type;

    @NotNull(message = "Start date is required.")
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;






}
