package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Patient;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
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

    @PostMapping("/patientcreate")
    public ModelAndView patientCreatePost(@ModelAttribute  Patient patient,HttpSession session,Model model){
        String encodepassword= BCrypt.hashpw(patient.getPassword(),BCrypt.gensalt());
        patient.setPassword(encodepassword);
        session.setAttribute("patientid", patient);
        patient.setRoles("paitent");
        model.addAttribute("patientname",patient.getPatient_name());
        dao.save(patient);
        return new ModelAndView("/patient/patientdashboard");
    }

    @GetMapping("/patientview")
    public String patientview(Model model,HttpSession session){
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return "redirect:/login";
        }
        List<Patient> patients = dao.findAll();
        model.addAttribute("patients",patients);
        return "/patient/patientview";
    }

    @GetMapping("/delete/patient/{patient_id}")
    public String deletePatient(@PathVariable("patient_id")Long patient_id, HttpSession session){
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return "redirect:/login";
        }
        dao.deleteById(patient_id);
        return  "redirect:/patientview";
    }

    @GetMapping("/patient/edit/{patient_id}")
    public ModelAndView editPatient(@PathVariable("patient_id")Long patient_id,HttpSession session){
        Patient checkPatient =(Patient) session.getAttribute("patient");
        if (checkPatient == null){
            return new ModelAndView("redirect:/login");
        }
        Patient patient =dao.findById(patient_id).orElseThrow();
        return new ModelAndView("/patient/patientedit","patientBean",patient);
    }
    @PostMapping("/patient/update")
    public String updatePatient(@ModelAttribute("patientBean")Patient patient){
        String encodepassword= BCrypt.hashpw(patient.getPassword(),BCrypt.gensalt());
        patient.setPassword(encodepassword);
        dao.save(patient);
        return "redirect:/patientview";
    }

}
