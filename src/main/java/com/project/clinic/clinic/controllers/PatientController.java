package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientDao dao ;

    @GetMapping("/Sigin")
    public String signin(){
        return "/patient/patient_reg";
    }
    @GetMapping("/patientview")
    public String patientview(Model model){
        List<Patient> patients = dao.findAll();
        model.addAttribute("patient",patients);
        return "/patient/patientview";
    }

}
