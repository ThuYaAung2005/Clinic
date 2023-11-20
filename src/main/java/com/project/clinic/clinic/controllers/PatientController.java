package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.PatientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {
    @Autowired
    PatientDao dao ;
    @GetMapping("/Sigin")
    public String signin(){
        return "/patient/patient_reg";
    }

}
