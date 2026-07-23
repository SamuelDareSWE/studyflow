package com.studyflow.studyflow_backend.academicperiod.service;

import com.studyflow.studyflow_backend.academicperiod.dto.AcademicPeriodResponse;
import com.studyflow.studyflow_backend.academicperiod.dto.CreateAcademicPeriodRequest;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;


public interface AcademicPeriodService {
    AcademicPeriodResponse createAcademicPeriod(CreateAcademicPeriodRequest request);

    AcademicPeriodResponse getAcademicPeriodById(Long id);

    Page<AcademicPeriodResponse> getAllAcademicPeriods(Pageable pageable);

    AcademicPeriodResponse updateAcademicPeriod(Long id, CreateAcademicPeriodRequest request);

    void deleteAcademicPeriod(Long id);
}
