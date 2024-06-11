package com.Medical.MEmergency.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Medical.MEmergency.entity.HospitalDoctor;

public interface HospitalDoctorRepository extends JpaRepository<HospitalDoctor, Long> {
    List<HospitalDoctor> findByHospitalId(Long hospitalId);
}
