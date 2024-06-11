package com.Medical.MEmergency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Medical.MEmergency.dto.EmergencyDto;
import com.Medical.MEmergency.entity.Emergency;
import com.Medical.MEmergency.entity.Hospital;
import com.Medical.MEmergency.repository.EmergencyRepository;
import com.Medical.MEmergency.service.HospitalService;

@RestController
@RequestMapping("/emergencies")
public class EmergencyController {

    @Autowired
    private EmergencyRepository emergencyRepository;

    @Autowired
    private HospitalService hospitalService;

    @PostMapping
    public Emergency reportEmergency(@RequestBody EmergencyDto emergencyDto) {
        Emergency emergency = new Emergency();
        emergency.setPhoneNumber(emergencyDto.getPhoneNumber());
        emergency.setDiseaseType(emergencyDto.getDiseaseType());
        emergency.setReportedAt(emergencyDto.getReportedAt());
        return emergencyRepository.save(emergency);
    }

    @GetMapping("/nearby-hospitals")
    public List<Hospital> getNearbyHospitals(@RequestParam String diseaseType,
                                             @RequestParam double latitude,
                                             @RequestParam double longitude) {
        return hospitalService.findNearbyHospitals(diseaseType, latitude, longitude);
    }
}
