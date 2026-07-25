package com.studyflow.studyflow_backend.academicperiod.controller;

import com.studyflow.studyflow_backend.academicperiod.dto.AcademicPeriodResponse;
import com.studyflow.studyflow_backend.academicperiod.dto.CreateAcademicPeriodRequest;
import com.studyflow.studyflow_backend.academicperiod.service.AcademicPeriodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/academic-periods")
public class AcademicPeriodController {

    private final AcademicPeriodService academicPeriodService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcademicPeriodResponse createAcademicPeriod(
           @Valid @RequestBody CreateAcademicPeriodRequest request){
        return academicPeriodService.createAcademicPeriod(request);
    }

}
