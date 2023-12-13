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
@PostMapping("/admin/login")
public String adminLogin(@RequestParam String email, String password, HttpSession session, Model model){
    if(!email.equals("") && !password.equals("")) {
        Admin admin = dao.getAdminByEmailAndPassword(email, password);
        boolean resultAdmin = (admin != null);
        Doctor doctor = dao2.getDoctorByEmailAndPassword(email, password);
        boolean resultDoctor = (doctor != null);
        if (resultAdmin == true) {
            session.setAttribute("admin", admin);
            //    model.addAttribute("admin345",admin.getAdmin_name());
            return "/admin/";
        }

            else if (resultDoctor){
            session.setAttribute("doctor",doctor);
            return "";
        }
        else {
            Patient patient=dao1.getPatientByEmailAndPassword(email,password);
            boolean resultPatient= (patient != null);
            if(resultPatient == true){
                session.setAttribute("patient",patient);
             //   model.addAttribute("staff456",staff.getName());
                return "/admin/";
            }else {
                return "redirect:/";
            }
        }
    } else {
        return "redirect:/";
    }
}

}

