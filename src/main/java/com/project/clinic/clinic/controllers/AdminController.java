package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.AdminDao;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
        @Autowired
         AdminDao dao;
        @Autowired
        DoctorDao doadoctor;
        @Autowired
    PatientDao patientDao;



    @GetMapping("/create")
    public String createDoctorGet(){
        return"/doctor/createdoctor";
    }
    @PostMapping("/create")
    public String createDoctorPost(@RequestParam String doctor_name, String doctor_email, String doctor_address, String doctor_phone, String doctor_specialty , String doctor_dob  ){
        Doctor doctor=new Doctor();
        doctor.setDoctor_name(doctor_name);
        doctor.setDoctor_email(doctor_email);
        doctor.setDoctor_address(doctor_address);
        doctor.setDoctor_phone(doctor_phone);
        doctor.setDoctor_specialty(doctor_specialty);
        doctor.setDoctor_dob(doctor_dob);
        doadoctor.save(doctor);
        return "admin/doctorview";

    }
    @GetMapping("/admincreate")
    public String adminCreateGet(){
        return "/admin/admindashboard";
    }
    @PostMapping("/admincreate")
    public String adminCreatePost(@RequestParam String admin_name,String admin_email ,String admin_phone,String admin_password){
        Admin admin= new Admin();
        admin.setAdmin_name(admin_name);
        admin.setAdmin_email(admin_email);
        admin.setAdmin_phone(admin_phone);
        admin.setAdmin_password(admin_password);
        dao.save(admin);
        return "/admincreate/adminview";
    }
    @GetMapping("/adminview")
    public String adminview(Model model){
        List<Admin> admins=dao.findAll();
        model.addAttribute("admins",admins);
        return "/admin/adminview";
    }
    @GetMapping("/patientview")
    public String patientview(Model model){
        List<Patient> patients = patientDao.findAll();
        model.addAttribute("patient",patients);
        return "/patient/patientview";
    }
    @GetMapping("/delete/admin/{admin_id}")
    public String getAdminById(@PathVariable("admin_id")Long admin_id){
      dao.deleteById(admin_id);
     return  "/adminview";
    }


}
