package com.example.RegisterLogin.Controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.RegisterLogin.Dto.HospitalDTO;
import com.example.RegisterLogin.Entity.Hospital;
import com.example.RegisterLogin.Service.HospitalService;

import java.util.List;

@Controller
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("hospitalDto", new HospitalDTO());
        return "register";
    }

    @PostMapping("/register")
    public String registerHospital(HospitalDTO hospitalDto, Model model) {
        Hospital hospital = hospitalService.registerHospital(hospitalDto);
        model.addAttribute("hospital", hospital);
        return "result";
    }
}

