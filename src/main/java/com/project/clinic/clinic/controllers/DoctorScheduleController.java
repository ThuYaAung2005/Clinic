package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.DoctorScheduleDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.DoctorSchedule;
import com.project.clinic.clinic.models.Patient;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class DoctorScheduleController {
    @Autowired
    DoctorDao doctorDao;

    @Autowired
    DoctorScheduleDao doctorScheduleDao;

    @GetMapping("/doctorschedulecreate")
    public ModelAndView createDoctorScheduleGet(HttpSession session) {
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return new ModelAndView("redirect:/login");
        }
        return new ModelAndView("/doctor/doctorcreate", "schedule", new DoctorSchedule());
    }
    @PostMapping("/doctorschedulecreate")
    public ModelAndView postDoctorSchedulecreate(@ModelAttribute("schedule") DoctorSchedule schedule, RedirectAttributes redirectAttributes){
        Doctor doctor=schedule.getDoctor();
//        System.out.println(doctor.getDoctor_address());
        String encodepassword= BCrypt.hashpw(doctor.getPassword(),BCrypt.gensalt());
        doctor.setPassword(encodepassword);
        doctor.setRoles("doctor");
//        redirectAttributes.addFlashAttribute("roles","doctor");
        doctorScheduleDao.save(schedule);
        return new ModelAndView("redirect:/doctorviewforadmin");
    }

    @GetMapping("/doctorscheduleview")
    public String doctorScheduleView(Model model, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("patient");
        if (patient ==null){
            return "redirect:/login";
        }
        List<DoctorSchedule> docSchedules = doctorScheduleDao.findAll();
        model.addAttribute("docSchedules", docSchedules);
        return "/doctorschedule/doctorscheduleview";
    }

    @GetMapping("/doctorscheduleviewfordoctor")
    public String doctorScheduleViewForDoctor(Model model, HttpSession session) {
        Doctor doctor = (Doctor) session.getAttribute("doctor");
        if (doctor ==null){
            return "redirect:/login";
        }
        List<DoctorSchedule> docSchedules = doctorScheduleDao.findAll();
        model.addAttribute("docSchedules", docSchedules);
        return "/doctor/doctorscheduleviewfordoctor";
    }
    @GetMapping("/delete/doctorschedule/{schedule_id}")
    public String deleteDoctorSchedule(@PathVariable("schedule_id") Long schedule_id, HttpSession session) {
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return "redirect:/login";
        }
        doctorScheduleDao.deleteById(schedule_id);
        return "redirect:/doctorscheduleview";
    }

    @GetMapping("/edit/doctorschedule/{schedule_id}")
    public ModelAndView doctorScheduleEdit(@PathVariable("schedule_id") Long schedule_id,HttpSession session) {
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return new ModelAndView("redirect:/login");
        }
        DoctorSchedule schedule = doctorScheduleDao.findById(schedule_id).orElseThrow();
        return new ModelAndView("/doctorschedule/doctorscheduleedit", "scheduleBean", schedule);
    }

    @PostMapping("/update/doctorschedule")
    public String updateAdmin(@ModelAttribute("doctorBean")  DoctorSchedule doctorSchedule) {
        doctorScheduleDao.save(doctorSchedule);
        return "redirect:/doctorscheduleview";
    }
}
