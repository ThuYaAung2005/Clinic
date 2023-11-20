package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientDao dao ;

    @GetMapping("/Sigin")
    public String signin(){
        return "/patient/patientcreate";
    }
    @GetMapping("/patientview")
    public String patientview(Model model){
        List<Patient> patients = dao.findAll();
        model.addAttribute("patient",patients);
        return "/patient/patientview";
    }

    @GetMapping("/patientcreate")
    public String patientcreateGet(){
        return "patient/patient_dashboard";
    }

    @PostMapping("/patientcreate")
    public String patientcreatePost(@RequestParam String patient_name,String patient_address,String patient_phoneno,String patient_dob,String patient_age,String patient_gender){
        Patient patient=new Patient();
        patient.setPatient_name(patient_name);
        patient.setPatient_address(patient_address);
        patient.setPatient_phoneno(patient_phoneno);
        patient.setPatient_dob(patient_dob);
        patient.setPatient_age(patient_age);
        patient.setPatient_gender(patient_gender);
        return "patient/patient_dashboard";
    }
}
