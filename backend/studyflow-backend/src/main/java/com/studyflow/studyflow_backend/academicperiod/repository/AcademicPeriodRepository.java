package com.studyflow.studyflow_backend.academicperiod.repository;

import com.studyflow.studyflow_backend.academicperiod.entity.AcademicPeriod;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface AcademicPeriodRepository extends JpaRepository<AcademicPeriod, Long> {

    Page<AcademicPeriod> findAllByDeletedFalse(Pageable pageable);

    Optional<AcademicPeriod> findByIdAndDeletedFalse(Long aLong);
}
