package com.studyflow.studyflow_backend.academicperiod.controller;

import com.studyflow.studyflow_backend.academicperiod.dto.AcademicPeriodResponse;
import com.studyflow.studyflow_backend.academicperiod.dto.CreateAcademicPeriodRequest;
import com.studyflow.studyflow_backend.academicperiod.service.AcademicPeriodService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/academic-periods")
public class AcademicPeriodController {

    private final AcademicPeriodService academicPeriodService;

    // Create an academic period
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcademicPeriodResponse createAcademicPeriod(
           @Valid @RequestBody CreateAcademicPeriodRequest request){
        return academicPeriodService.createAcademicPeriod(request);
    }

    // Get a single academic period
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AcademicPeriodResponse getAcademicPeriodById(
            @PathVariable Long id){
        return academicPeriodService.getAcademicPeriodById(id);
    }

    // Get all academic period but by measure
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<AcademicPeriodResponse> getAllAcademicPeriods(
            @PageableDefault(
                    page=0,
                    size = 10,
                    sort = "id") Pageable pageable) {

        return academicPeriodService.getAllAcademicPeriods(pageable);

    }

    // Update academic Period
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AcademicPeriodResponse updateAcademicPeriod(
            @PathVariable Long id,
            @Valid
            @RequestBody
            CreateAcademicPeriodRequest request) {

        return academicPeriodService.updateAcademicPeriod(id, request);

    }

}
