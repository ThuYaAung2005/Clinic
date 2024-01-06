package com.project.clinic.clinic.controllers;
import com.project.clinic.clinic.daos.AdminDao;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import com.project.clinic.clinic.util.CommonUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PageController {

    @Autowired
    AdminDao dao;

    @Autowired
    PatientDao dao1;

    @Autowired
    DoctorDao dao2;

    @Autowired
    HttpSession session;
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/profile")
    public String profile() {
        return "admin/adminacc";
    }

    @GetMapping("/dprofile")
    public String dprofile() {
        return "doctor/doctoracc";
    }

    @GetMapping("/pprofile")
    public String pprofile() {
        return "patient/patientacc";
    }



    @GetMapping("/login")
    public String login() {
        return "sigin";
    }

    @PostMapping("/login")
    private String login(@RequestParam String email, String password, String roles,Model model, RedirectAttributes redirectAttributes) {

//        System.out.println(email);
//        System.out.println(password);
//        System.out.println(roles);
        if (!CommonUtil.validString(email) || !CommonUtil.validString(password) || !CommonUtil.validString(roles)){
            return "redirect:/login";
        }
            if (roles.equals("admin")) {
                Admin admin = dao.getAdminByEmail(email);
                if (admin != null && admin.getPassword() != null && BCrypt.checkpw(password, admin.getPassword()) && email.equals(email)) {
                    session.setAttribute("admin", admin);
                    return "/admin/admindashboard";
                }
            }else if (roles.equals("doctor")){
                Doctor doctor = dao2.getDoctorByEmail(email);
                if (doctor != null && doctor.getPassword() != null && BCrypt.checkpw(password, doctor.getPassword()) && email.equals(email)) {
                    session.setAttribute("doctor", doctor);
                    return "/doctor/doctordashboard";
                }
            } else if(roles.equals("patient")){
                Patient patient = dao1.getPatientByEmail(email);
                System.out.println("database password"+patient.getPassword());
                System.out.println("database email"+patient.getEmail());
                System.out.println(password);
                System.out.println(email);
                if (patient != null && patient.getPassword() != null && BCrypt.checkpw(password, patient.getPassword()) && email.equals(email)) {
                    session.setAttribute("patient", patient);
                    return "/patient/patientdashboard";
                }
            }
        return "redirect:/login";
    }
    @RequestMapping(value = "/logout",method = RequestMethod.GET)
    public String userLogout(RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("logout", "You have been logged out");

        return "redirect:/login";
    }
}