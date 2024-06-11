package com.Medical.MEmergency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Medical.MEmergency.entity.HospitalDisease;
import com.Medical.MEmergency.repository.HospitalDiseaseRepository;

@Controller
public class HospitalDiseaseController {

    @Autowired
    private HospitalDiseaseRepository hospitalDiseaseRepository;

    @GetMapping("/hospital-diseases")
    public String showHospitalDiseases(Model model) {
        List<HospitalDisease> hospitalDiseases = hospitalDiseaseRepository.findAll();
        model.addAttribute("hospitalDiseases", hospitalDiseases);
        return "hospital-diseases";
    }

    @PostMapping("/hospital-diseases")
    public String addHospitalDisease(HospitalDisease hospitalDisease) {
        hospitalDiseaseRepository.save(hospitalDisease);
        return "redirect:/hospital-diseases";
    }
}