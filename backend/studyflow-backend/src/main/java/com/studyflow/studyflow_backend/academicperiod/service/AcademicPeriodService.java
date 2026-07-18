package com.studyflow.studyflow_backend.academicperiod.service;

import com.studyflow.studyflow_backend.academicperiod.dto.AcademicPeriodResponse;
import com.studyflow.studyflow_backend.academicperiod.dto.CreateAcademicPeriodRequest;

import java.util.List;

public interface AcademicPeriodService {
    AcademicPeriodResponse createAcademicPeriod(CreateAcademicPeriodRequest request);

    AcademicPeriodResponse getAcademicPeriodById(Long id);

    List<AcademicPeriodResponse> getAllAcademicPeriods();

    AcademicPeriodResponse updateAcademicPeriod(Long id, CreateAcademicPeriodRequest request);

    void deleteAcademicPeriod(Long id);
}
