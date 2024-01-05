package com.project.clinic.clinic.controllers;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.DoctorScheduleDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.DocSchedule;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorScheduleDao doctordao;

    @Autowired
    DoctorDao dao;

    @GetMapping("/doctorcreate")
    public ModelAndView createDoctorGet(HttpSession session) {
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin==null){
            return new ModelAndView("redirect:/login");
        }

            return new ModelAndView("/doctor/doctorcreate", "doctor", new Doctor());
        }

    @PostMapping("/doctorcreate")
    public ModelAndView createDoctorPost(@ModelAttribute Doctor doctor) {
        String encodepassword= BCrypt.hashpw(doctor.getPassword(),BCrypt.gensalt());
        doctor.setPassword(encodepassword);
        doctor.setRoles("doctor");
        dao.save(doctor);
        return new ModelAndView("redirect:/doctorschedulecreate");
    }


    @GetMapping("/doctorview")
    public String doctorView(Model model,HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        Admin admin = (Admin) session.getAttribute("admin");
        if  ( admin == null || doctor == null){
            return "redirect:/login";
        }
            List<Doctor> doctors = dao.findAll();
            model.addAttribute("doctors", doctors);
            return "/doctor/doctorview";
        }


    @GetMapping("/delete/doctor/{doctor_id}")
    public String deletedoctor(@PathVariable("doctor_id") Long doctor_id,HttpSession session) {
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return "redirect:/login";
        }
        dao.deleteById(doctor_id);
        return "redirect:/doctorview";
    }

    @GetMapping("/edit/doctor/{doctor_id}")
    public ModelAndView doctoredit(@PathVariable("doctor_id") Long doctor_id,HttpSession session) {
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return new ModelAndView("redirect:/login");
        }else{
        Doctor doctor = dao.findById(doctor_id).orElseThrow();
        return new ModelAndView("/doctor/doctoredit", "doctorBean", doctor);
    }

    }


    @PostMapping("/update/doctor")
    public String updateAdmin(@ModelAttribute("doctorBean") Doctor doctor) {
        String encodepassword= BCrypt.hashpw(doctor.getPassword(),BCrypt.gensalt());
        doctor.setPassword(encodepassword);
        dao.save(doctor);
        return "redirect:/doctorviewforadmin";
    }


}
