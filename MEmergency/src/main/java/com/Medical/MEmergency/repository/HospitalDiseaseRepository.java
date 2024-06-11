package com.Medical.MEmergency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Medical.MEmergency.entity.HospitalDisease;

public interface HospitalDiseaseRepository extends JpaRepository<HospitalDisease, Long> {
    List<HospitalDisease> findByDiseaseType(String diseaseType);
}
