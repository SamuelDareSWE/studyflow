package com.studyflow.studyflow_backend.academicperiod.mapper;

import com.studyflow.studyflow_backend.academicperiod.dto.AcademicPeriodResponse;
import com.studyflow.studyflow_backend.academicperiod.dto.CreateAcademicPeriodRequest;
import com.studyflow.studyflow_backend.academicperiod.entity.AcademicPeriod;
import org.springframework.stereotype.Component;

@Component
public class AcademicPeriodMapper {
    public AcademicPeriod toEntity(CreateAcademicPeriodRequest request) {
        if (request == null){
            return null;
        }
        AcademicPeriod entity = new AcademicPeriod();
        entity.setName(request.getName());
        entity.setType(request.getType());
        entity.setYear(request.getYear());
        entity.setStartDate(request.getStartDate());
        entity.setEndDate(request.getEndDate());

        return entity;
    }

    public AcademicPeriodResponse toResponse(AcademicPeriod entity) {
        if (entity == null){
            return null;
        }

        AcademicPeriodResponse response = new AcademicPeriodResponse();
        response.setName(entity.getName());
        response.setType(entity.getType());
        response.setYear(entity.getYear());
        response.setStartDate(entity.getStartDate());
        response.setEndDate(entity.getEndDate());
        response.setId(entity.getId());
        response.setActive(entity.getActive());

        return response;
    }


}


