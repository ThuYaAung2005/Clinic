package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.DoctorScheduleDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.DocSchedule;
import com.project.clinic.clinic.models.Doctor;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

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
        return new ModelAndView("/doctorschedule/doctorschedulecreate", "schedule", new DocSchedule());
    }

//    @PostMapping("/doctorschedulecreate")
//    public ModelAndView createDoctorSchedulePost(@ModelAttribute DocSchedule schedule) {
//        Doctor lastDoctor = doctorDao.findTopByOrderByDoctor_idDesc();
//
//        // Check if the last doctor is null
//        if (lastDoctor != null) {
//            // Get the last doctor's ID
//            Long lastDoctorId = lastDoctor.getDoctor_id();
//
//            // Find the doctor by the retrieved ID
//            Doctor doctor = doctorDao.findById(lastDoctorId).orElse(null);
//
//            // Check if the doctor is null
//            if (doctor != null) {
//                // Set the doctor to the schedule
//                schedule.setDoctor(doctor);
//
//                // Save the schedule
//                doctorScheduleDao.save(schedule);
//
//                return new ModelAndView("redirect:/doctorscheduleview");
//            } else {
//                // Handle the case when the doctor is null
//                // Redirect to an error page or log the error
//                return new ModelAndView("redirect:/doctorschedulecreate");
//            }
//        } else {
//            // Handle the case when the last doctor is null
//            // Redirect to an error page or log the erro
//            return new ModelAndView("redirect:/doctorschedulecreate");
//        }
//    }
    @GetMapping("/doctorscheduleview")
    public String doctorScheduleView(Model model, HttpSession session) {
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return "redirect:/login";
        }
        List<DocSchedule> docSchedules = doctorScheduleDao.findAll();
        model.addAttribute("docSchedules", docSchedules);
        return "/doctorschedule/doctorscheduleview";
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
        DocSchedule schedule = doctorScheduleDao.findById(schedule_id).orElseThrow();
        return new ModelAndView("/doctorschedule/doctorscheduleedit", "scheduleBean", schedule);
    }

    @PostMapping("/update/doctorschedule")
    public String updateAdmin(@ModelAttribute("doctorBean") DocSchedule schedule) {
        doctorScheduleDao.save(schedule);
        return "redirect:/doctorscheduleview";
    }
}
