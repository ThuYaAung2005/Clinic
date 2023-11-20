package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PatientController {
    @Autowired
    PatientDao dao ;

    @GetMapping("/Sigin")
    public String signin(){
        return "/patient/patient_reg";
    }

    @GetMapping("/create")
    public String patientcreateGet(){
        return "patient/patient_dashboard.html";
    }

    @PostMapping("/create")
    public String patientcreatePost(@RequestParam String patient_name,String patient_address,String patient_phoneno,String patient_dob,String patient_age,String patient_gender){
        Patient patient=new Patient();
        patient.setPatient_name(patient_name);
        patient.setPatient_address(patient_address);
        patient.setPatient_phoneno(patient_phoneno);
        patient.setPatient_dob(patient_dob);
        patient.setPatient_age(patient_age);
        patient.setPatient_gender(patient_gender);
        return "patient/patient_dashboard.html";

    }

}
