package com.Medical.MEmergency.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.Medical.MEmergency.config.GeoApiContextConfig;
import com.Medical.MEmergency.dto.DoctorDto;
import com.Medical.MEmergency.dto.HospitalDiseaseDto;
import com.Medical.MEmergency.dto.RegisterHospitalDto;
import com.Medical.MEmergency.entity.Doctor;
import com.Medical.MEmergency.entity.Hospital;
import com.Medical.MEmergency.entity.HospitalDisease;
import com.Medical.MEmergency.repository.DoctorRepository;
import com.Medical.MEmergency.repository.HospitalDiseaseRepository;
import com.Medical.MEmergency.repository.HospitalRepository;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private HospitalDiseaseRepository hospitalDiseaseRepository;

    @Autowired
    private DoctorRepository doctorRepository;
    
    @Autowired
    private GeoApiContextConfig geoApiContext;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public void registerHospital(RegisterHospitalDto hospitalDto) {
        Hospital hospital = new Hospital();
        hospital.setName(hospitalDto.getName());
        hospital.setAddress(hospitalDto.getAddress());
        hospital.setLatitude(hospitalDto.getLatitude());
        hospital.setLongitude(hospitalDto.getLongitude());
        hospital.setContactNumber(hospitalDto.getContactNumber());
        hospital.setUsername(hospitalDto.getUsername());
        hospital.setPassword(bCryptPasswordEncoder.encode(hospitalDto.getPassword()));
        hospitalRepository.save(hospital);
    }

    public boolean loginHospital(RegisterHospitalDto hospitalDto) {
        Hospital hospital = hospitalRepository.findByUsername(hospitalDto.getUsername()).orElse(null);
        return hospital != null && bCryptPasswordEncoder.matches(hospitalDto.getPassword(), hospital.getPassword());
    }

    public void addDoctor(DoctorDto doctorDto) {
        Optional<Hospital> optionalHospital = hospitalRepository.findByUsername(doctorDto.getHospitalUsername());
        if (optionalHospital.isPresent()) {
            Hospital hospital = optionalHospital.get();
            Doctor doctor = new Doctor();
            doctor.setName(doctorDto.getName());
            doctor.setSpeciality(doctorDto.getSpeciality());
            doctor.setContactNumber(doctorDto.getContactNumber());
            doctor.setHospital(hospital);
            doctorRepository.save(doctor);
        } else {
            throw new RuntimeException("Hospital not found with username: " + doctorDto.getHospitalUsername());
        }
    }


    public void addDisease(HospitalDiseaseDto diseaseDto) {
        Hospital hospital = hospitalRepository.findByUsername(diseaseDto.getHospitalUsername()).orElse(null);
        if (hospital != null) {
            HospitalDisease disease = new HospitalDisease();
            disease.setDiseaseType(diseaseDto.getDiseaseType());
            disease.setHospital(hospital);
            hospitalDiseaseRepository.save(disease);
        }
    }

    public List<Hospital> findNearbyHospitals(String diseaseType, double latitude, double longitude) {
        // Get hospitals that handle the specified disease
        List<Long> hospitalIds = hospitalDiseaseRepository.findByDiseaseType(diseaseType)
                .stream()
                .map(hd -> hd.getHospital().getId())
                .collect(Collectors.toList());

        List<Hospital> hospitals = hospitalRepository.findAllById(hospitalIds);

        // Filter hospitals based on distance using Haversine formula
        return hospitals.stream()
                .filter(hospital -> isWithinDistance(hospital, latitude, longitude, 10)) // e.g., within 10km
                .collect(Collectors.toList());
    }

    private boolean isWithinDistance(Hospital hospital, double latitude, double longitude, double maxDistance) {
        double distance = calculateDistance(latitude, longitude, hospital.getLatitude(), hospital.getLongitude());
        return distance <= maxDistance;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Haversine formula to calculate distance
        final int R = 6371; // Radius of the Earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Distance in km
    }
}
