package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.DoctorScheduleDao;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.DocSchedule;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView createDoctorGet() {
        return new ModelAndView("/doctor/doctorcreate", "doctor", new Doctor());
    }

    @PostMapping("/doctorcreate")
    public ModelAndView createDoctorPost(@ModelAttribute Doctor doctor) {
        dao.save(doctor);
        return new ModelAndView("redirect:/doctorview");
    }

    @GetMapping("/doctorview")
    public String doctorView(Model model) {
        List<Doctor> doctors = dao.findAll();
        model.addAttribute("doctors", doctors);
        return "/doctor/doctorview";
    }

    @GetMapping("/delete/doctor/{doctor_id}")
    public String deletedoctor(@PathVariable("doctor_id") Long doctor_id) {
        dao.deleteById(doctor_id);
        return "redirect:/doctorview";
    }

    @GetMapping("/edit/doctor/{doctor_id}")
    public ModelAndView doctoredit(@PathVariable("doctor_id") Long doctor_id) {
        Doctor doctor = dao.findById(doctor_id).orElseThrow();
        return new ModelAndView("/doctor/doctoredit", "doctorBean", doctor);
    }

    @PostMapping("/update/doctor")
    public String updateAdmin(@ModelAttribute("doctorBean") Doctor doctor) {
        dao.save(doctor);
        return "redirect:/doctorview";
    }





    @GetMapping("/doctorschedulecreate")
    public ModelAndView createDoctorScheduleGet() {
        return new ModelAndView("/doctorschedule/doctorschedulecreate", "schedule", new DocSchedule());
    }

    @PostMapping("/doctorschedulecreate")
    public ModelAndView createDoctorSchedulePost(@ModelAttribute DocSchedule schedule) {
        doctordao.save(schedule);
        return new ModelAndView("redirect:/doctorscheduleview");
    }

    @GetMapping("/doctorscheduleview")
    public String doctorScheduleView(Model model) {
        List<DocSchedule> docSchedules = doctordao.findAll();
        model.addAttribute("docSchedules", docSchedules);
        return "/doctorschedule/doctorscheduleview";
    }

    @GetMapping("/delete/doctorschedule/{schedule_id}")
    public String deleteDoctorSchedule(@PathVariable("schedule_id") Long schedule_id) {
        doctordao.deleteById(schedule_id);
        return "redirect:/doctorscheduleview";
    }

    @GetMapping("/edit/doctorschedule/{schedule_id}")
    public ModelAndView doctorScheduleEdit(@PathVariable("schedule_id") Long schedule_id) {
        DocSchedule schedule = doctordao.findById(schedule_id).orElseThrow();
        return new ModelAndView("/doctorschedule/doctorscheduleedit", "scheduleBean", schedule);
    }

    @PostMapping("/update/doctorschedule")
    public String updateAdmin(@ModelAttribute("doctorBean") DocSchedule schedule) {
        doctordao.save(schedule);
        return "redirect:/doctorscheduleview";
    }
}
