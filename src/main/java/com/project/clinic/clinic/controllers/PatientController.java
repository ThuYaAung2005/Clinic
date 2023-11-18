package com.project.clinic.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @GetMapping("/Sigin")
    public String signin(){
        return "/patient/patient_reg";
    }
    @GetMapping("/paitentDeskboard")
    public String paitentDeskBoard(){
        return "/patient/patient_deskboard";
    }
}
