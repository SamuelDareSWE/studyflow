package com.studyflow.studyflow_backend.academicperiod.service;

import com.studyflow.studyflow_backend.academicperiod.dto.AcademicPeriodResponse;
import com.studyflow.studyflow_backend.academicperiod.dto.CreateAcademicPeriodRequest;
import com.studyflow.studyflow_backend.academicperiod.entity.AcademicPeriod;
import com.studyflow.studyflow_backend.academicperiod.mapper.AcademicPeriodMapper;
import com.studyflow.studyflow_backend.academicperiod.repository.AcademicPeriodRepository;
import com.studyflow.studyflow_backend.common.exception.BadRequestException;
import com.studyflow.studyflow_backend.common.exception.ResourceNotFoundException;
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

       AcademicPeriod academicPeriod = findAcademicPeriodById(id);

       return academicPeriodMapper.toResponse(academicPeriod);


    }



    @Override
    public Page<AcademicPeriodResponse> getAllAcademicPeriods(Pageable pageable) {

        return academicPeriodRepository.findAllByDeletedFalse(pageable)
                .map(academicPeriodMapper::toResponse);

    }

    @Override
    public AcademicPeriodResponse updateAcademicPeriod(Long id, CreateAcademicPeriodRequest request) {

        validateAcademicPeriodDates(request);

        AcademicPeriod existingAcademicPeriod = findAcademicPeriodById(id);

        academicPeriodMapper.updateEntity(existingAcademicPeriod, request);

        AcademicPeriod saved = academicPeriodRepository.save(existingAcademicPeriod);

        return academicPeriodMapper.toResponse(existingAcademicPeriod);
    }

    @Override
    public void deleteAcademicPeriod(Long id) {

        AcademicPeriod academicPeriod = findAcademicPeriodById(id);

        academicPeriod.setActive(false);
        academicPeriod.setDeleted(true);

        academicPeriodRepository.save(academicPeriod);

    }

    private void validateAcademicPeriodDates(CreateAcademicPeriodRequest request) {

        if (request.getStartDate() != null
                && request.getEndDate() != null
                && request.getStartDate().isAfter(request.getEndDate())) {

            throw new BadRequestException(
                    "Start date can not be after the end date."
            );
        }
    }

    private AcademicPeriod findAcademicPeriodById(Long id) {
        return academicPeriodRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Academic period not found with the id: " + id));
    }

    private AcademicPeriod createAcademicPeriodEntity(
            CreateAcademicPeriodRequest request) {

        AcademicPeriod entity = academicPeriodMapper.toEntity(request);

        entity.setActive(true);

        return entity;
    }

}
