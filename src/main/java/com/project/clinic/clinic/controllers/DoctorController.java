package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.DoctorScheduleDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.DoctorSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.model.IDocType;

import java.util.List;

@Controller
public class DoctorController {

    @Autowired
    DoctorScheduleDao doctordao;
    @Autowired
    DoctorDao dao;

    @GetMapping("/viewdoctorschedule")
    public String viewDoctorSchedule(Model model){

        List<DoctorSchedule> schedules = doctordao.findAll();
        model.addAttribute("schedules",schedules);
        return "/doctor/doctorschedule";
    }

    @GetMapping("/doctorcreate")
    public String createDoctorGet(){
        return"/doctor/createdoctor";
    }
    @PostMapping("/doctorcreate")
    public String createDoctorPost(@RequestParam String doctor_name, String doctor_email, String doctor_address, String doctor_phone, String doctor_specialty , String doctor_dob  ){
        Doctor doctor=new Doctor();
        doctor.setDoctor_name(doctor_name);
        doctor.setDoctor_email(doctor_email);
        doctor.setDoctor_address(doctor_address);
        doctor.setDoctor_phone(doctor_phone);
        doctor.setDoctor_specialty(doctor_specialty);
        doctor.setDoctor_dob(doctor_dob);
        dao.save(doctor);
        return "admin/doctorview";

    }
    @GetMapping("/doctorview")
    public String adminview(Model model){
        List<Doctor> doctors=dao.findAll();
        model.addAttribute("doctors",doctors);
        return "/doctor/doctorview";
    }
    @GetMapping("/delete/doctor/{doctor_id}")
    public String deletedoctor(@PathVariable("doctor_id")Long doctor_id){
        dao.deleteById(doctor_id);
        return  "/adminview";
    }
    @GetMapping("/edit/doctor/{doctor_id}")
    public ModelAndView adminedit(@PathVariable("admin_id")Long doctor_id){
        Doctor doctor =dao.findById(doctor_id).orElseThrow();
        return new ModelAndView("/admin/adminedit","adminBean",doctor);
    }
}
