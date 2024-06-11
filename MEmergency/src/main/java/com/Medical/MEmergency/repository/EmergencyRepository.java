package com.Medical.MEmergency.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Medical.MEmergency.entity.Emergency;

public interface EmergencyRepository extends JpaRepository<Emergency, Long> {
}