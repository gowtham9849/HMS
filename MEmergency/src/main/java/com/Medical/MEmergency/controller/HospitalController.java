package com.Medical.MEmergency.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Medical.MEmergency.dto.DoctorDto;
import com.Medical.MEmergency.dto.HospitalDiseaseDto;
import com.Medical.MEmergency.dto.RegisterHospitalDto;
import com.Medical.MEmergency.entity.Hospital;
import com.Medical.MEmergency.repository.HospitalRepository;
import com.Medical.MEmergency.service.HospitalService;

//@RestController
//@RequestMapping("/hospitals")
//public class HospitalController {
//
//    @Autowired
//    private HospitalRepository hospitalRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @PostMapping("/register")
//    public Hospital registerHospital(@RequestBody RegisterHospitalDto registerHospitalDto) {
//        Hospital hospital = new Hospital();
//        hospital.setName(registerHospitalDto.getName());
//        hospital.setAddress(registerHospitalDto.getAddress());
//        hospital.setLatitude(registerHospitalDto.getLatitude());
//        hospital.setLongitude(registerHospitalDto.getLongitude());
//        hospital.setContactNumber(registerHospitalDto.getContactNumber());
//        hospital.setUsername(registerHospitalDto.getUsername());
//        hospital.setPassword(passwordEncoder.encode(registerHospitalDto.getPassword()));
//        return hospitalRepository.save(hospital);
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestBody LoginDto loginDto) {
//        Optional<Hospital> hospitalOpt = hospitalRepository.findByUsername(loginDto.getUsername());
//        if (hospitalOpt.isPresent()) {
//            Hospital hospital = hospitalOpt.get();
//            if (passwordEncoder.matches(loginDto.getPassword(), hospital.getPassword())) {
//                return "Login successful";
//            }
//        }
//        return "Invalid credentials";
//    }
//}
@Controller
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("hospital", new RegisterHospitalDto());
        return "register";
    }

    @PostMapping("/hospitals/register")
    public String registerHospital(@ModelAttribute RegisterHospitalDto hospitalDto) {
        hospitalService.registerHospital(hospitalDto);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("hospital", new RegisterHospitalDto());
        return "login";
    }

    @PostMapping("/hospitals/login")
    public String loginHospital(@ModelAttribute RegisterHospitalDto hospitalDto, Model model) {
        if (hospitalService.loginHospital(hospitalDto)) {
            return "redirect:/dashboard";
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }

    @GetMapping("/dashboard")
    public String showDashboard() {
        return "dashboard";
    }

    @GetMapping("/hospitals/doctors")
    public String showAddDoctorForm(Model model) {
        model.addAttribute("doctor", new DoctorDto());
        return "add-doctor";
    }

    @PostMapping("/hospitals/doctors")
    public String addDoctor(@ModelAttribute DoctorDto doctorDto) {
        hospitalService.addDoctor(doctorDto);
        return "redirect:/dashboard";
    }

    @GetMapping("/hospitals/diseases")
    public String showAddDiseaseForm(Model model) {
        model.addAttribute("disease", new HospitalDiseaseDto());
        return "add-disease";
    }

    @PostMapping("/hospitals/diseases")
    public String addDisease(@ModelAttribute HospitalDiseaseDto diseaseDto) {
        hospitalService.addDisease(diseaseDto);
        return "redirect:/dashboard";
    }
}