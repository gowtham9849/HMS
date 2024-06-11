package com.example.RegisterLogin.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.Dto.HospitalDTO;
import com.example.RegisterLogin.Entity.Hospital;
import com.example.RegisterLogin.Repository.HospitalRepository;

@Service
public class HospitalService {

    @Autowired
    private HospitalRepository hospitalRepository;

    public Hospital registerHospital(HospitalDTO hospitalDTO) {
        Hospital hospital = new Hospital();
        hospital.setName(hospitalDTO.getName());
        hospital.setAddress(hospitalDTO.getAddress());
        hospital.setContactNumber(hospitalDTO.getContactNumber());
        hospital.setLatitude(hospitalDTO.getLatitude());
        hospital.setLongitude(hospitalDTO.getLongitude());
        return hospitalRepository.save(hospital);
    }

    public List<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }
}
