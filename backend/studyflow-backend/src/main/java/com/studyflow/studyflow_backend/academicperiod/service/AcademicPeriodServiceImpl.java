package com.studyflow.studyflow_backend.academicperiod.service;

import com.studyflow.studyflow_backend.academicperiod.dto.AcademicPeriodResponse;
import com.studyflow.studyflow_backend.academicperiod.dto.CreateAcademicPeriodRequest;
import com.studyflow.studyflow_backend.academicperiod.entity.AcademicPeriod;
import com.studyflow.studyflow_backend.academicperiod.mapper.AcademicPeriodMapper;
import com.studyflow.studyflow_backend.academicperiod.repository.AcademicPeriodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
@Service
public class AcademicPeriodServiceImpl implements AcademicPeriodService {

    private final AcademicPeriodRepository academicPeriodRepository;
    private final AcademicPeriodMapper academicPeriodMapper;

    @Override
    public AcademicPeriodResponse createAcademicPeriod(CreateAcademicPeriodRequest request) {

        validateAcademicPeriodDates(request);

        AcademicPeriod entity = createAcademicPeriodEntity(request);

        AcademicPeriod savedEntity = academicPeriodRepository.save(entity);

        return academicPeriodMapper.toResponse(savedEntity);
    }

    @Override
    public AcademicPeriodResponse getAcademicPeriodById(Long id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }



    @Override
    public Page<AcademicPeriodResponse> getAllAcademicPeriods(Pageable pageable) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public AcademicPeriodResponse updateAcademicPeriod(Long id, CreateAcademicPeriodRequest request) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public void deleteAcademicPeriod(Long id) {

    }

    private void validateAcademicPeriodDates(CreateAcademicPeriodRequest request) {

        if (request.getStartDate() != null
                && request.getEndDate() != null
                && request.getStartDate().isAfter(request.getEndDate())) {

            throw new IllegalArgumentException(
                    "Start date cannot be after end date.");
        }
    }

    private AcademicPeriod createAcademicPeriodEntity(
            CreateAcademicPeriodRequest request) {

        AcademicPeriod entity = academicPeriodMapper.toEntity(request);

        entity.setActive(true);

        return entity;
    }

}
