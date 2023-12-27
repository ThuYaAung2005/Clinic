package com.project.clinic.clinic.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Patient;
import com.project.clinic.clinic.models.PatientHealth;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientHealthController {
    @Autowired
    HttpSession session;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    PatientDao patientDao;
    @GetMapping("patienthealthcreate")
    public ModelAndView patientHealthCreate(){
        return new ModelAndView("","patientHealth",new PatientHealth());
    }
    @PostMapping("patienthealthcreate")
    public String patientHealthCreatePost(){
        return "";
    }
}
