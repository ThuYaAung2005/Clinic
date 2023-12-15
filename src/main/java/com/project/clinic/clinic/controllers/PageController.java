package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.AdminDao;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class PageController {

    @Autowired
    AdminDao dao;

    @Autowired
    PatientDao dao1;

    @Autowired
    DoctorDao dao2;

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "sigin";
    }

//    @GetMapping("/adminlogin")
//    public String adminLogin(){
//        return "admin/adminlogin";
//    }
//    @GetMapping("/doctorlogin")
//    public String doctorLogin(){
//        return "doctor/doctorlogin";
//    }
//    @GetMapping("/patientlogin")
//    public String patientLogin(){
//        return "patient/patientlogin";
//    }

@PostMapping("/login")
    public String loginPage(@RequestParam String email,String password,HttpSession session){
        if(!email.equals("") && !password.equals("")){
            Admin admin = dao.getAdminByEmailAndPassword(email, password);
            session.setAttribute("admin",admin);
            boolean resultAdmin = (admin != null);
            if(resultAdmin){
                return "/admin/admindashboard";
            }else{
                Doctor doctor = dao2.getDoctorByEmailAndPassword(email, password);
                session.setAttribute("doctor",doctor);
                boolean resultDoctor = (doctor != null);
                if(resultDoctor){
                    return "/doctor/doctordashboard";
                }else {
                    Patient patient=dao1.getPatientByEmailAndPassword(email,password);
                    session.setAttribute("patient",patient);
                    boolean resultPatient= (patient != null);
                    if(resultPatient){
                        return "/patient/patientdashboard";
                    }else{
                        return "redirect:/login";
                    }
                }
            }
        }else{
            return "redirect:/login";
        }
}

}

