package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.DoctorScheduleDao;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.DoctorSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorScheduleDao doctordao;

    @GetMapping("/viewdoctorschedule")
    public String viewDoctorSchedule(Model model){

        List<DoctorSchedule> schedules = doctordao.findAll();
        model.addAttribute("schedules",schedules);
        return "/doctor/doctorschedule";
    }



}
