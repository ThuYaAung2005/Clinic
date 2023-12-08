package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientDao dao ;

    @GetMapping("/Sigin")
    public ModelAndView sigin() {
        return new ModelAndView("/patient/patientcreate","patient",new Patient());
    }
    @GetMapping("/patientview")
    public String patientview(Model model){
        List<Patient> patients = dao.findAll();
        model.addAttribute("patients",patients);
        return "/patient/patientview";
    }


    @PostMapping("/patientcreate")
    public ModelAndView patientCreatePost(@ModelAttribute  Patient patient){

        dao.save(patient);
        return new ModelAndView("redirect:/patientview");
    }
    @GetMapping("/delete/patient/{patient_id}")
    public String deletePatient(@PathVariable("patient_id")Long patient_id){
        dao.deleteById(patient_id);
        return  "/patient/patientview";
    }
//    @GetMapping("/patientview")
//    public String patientView(Model model){
//        List<Patient> patients=dao.findAll();
//        model.addAttribute("patients",patients);
//        return "/patient/patient;";
//    }

    @GetMapping("/edit/patient/{patient_id}")
    public ModelAndView editPatient(@PathVariable("patient_id")Long patient_id){
        Patient patient =dao.findById(patient_id).orElseThrow();
        return new ModelAndView("/patient/patientedit","patientBean",patient);
    }
    @PostMapping("/update/patient")
    public String updatePatient(@ModelAttribute("patientBean")Patient patient){
        dao.save(patient);
        return "redirect:/patient/patientview";
    }

}
