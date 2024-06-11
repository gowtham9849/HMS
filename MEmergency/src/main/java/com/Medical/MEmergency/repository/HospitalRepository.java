package com.Medical.MEmergency.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Medical.MEmergency.entity.Hospital;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
    Optional<Hospital> findByUsername(String username);
}
