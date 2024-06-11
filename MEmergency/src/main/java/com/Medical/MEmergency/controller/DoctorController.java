package com.Medical.MEmergency.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.Medical.MEmergency.entity.Doctor;
import com.Medical.MEmergency.repository.DoctorRepository;

@Controller
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/doctors")
    public String showDoctors(Model model) {
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors", doctors);
        return "doctors";
    }

    @PostMapping("/doctors")
    public String addDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
        return "redirect:/doctors";
    }
}