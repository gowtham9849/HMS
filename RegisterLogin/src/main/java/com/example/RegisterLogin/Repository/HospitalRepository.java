package com.example.RegisterLogin.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RegisterLogin.Entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}