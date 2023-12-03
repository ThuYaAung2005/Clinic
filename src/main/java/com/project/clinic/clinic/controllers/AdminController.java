package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.AdminDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
        @Autowired
         AdminDao dao;

    @GetMapping("/admincreate")
    public String adminCreateGet(){
        return "/admin/admincreate";
    }

    @PostMapping("/admincreate")
    public String adminCreatePost(@RequestParam String admin_name ,String admin_email,String admin_phone,String admin_password){
        Admin admin= new Admin();
        admin.setAdmin_name(admin_name);
        admin.setAdmin_phone(admin_phone);
        admin.setAdmin_email(admin_email);
        admin.setAdmin_password(admin_password);
        dao.save(admin);
        return "redirect:/adminview";
    }
    @GetMapping("/adminview")
    public String adminview(Model model){
        List<Admin> admins=dao.findAll();
        model.addAttribute("admins",admins);
        return "/admin/adminview";
    }

    @GetMapping("/delete/admin/{admin_id}")
    public String deleteadim(@PathVariable("admin_id") Long admin_id){
      dao.deleteById(admin_id);
     return  "redirect:/adminview";
    }

    @GetMapping("/edit/admin/{admin_id}")
    public ModelAndView adminedit(@PathVariable("admin_id") Long admin_id){
        Admin admin =dao.findById(admin_id).orElseThrow();
        return new ModelAndView("/admin/adminedit","adminBean",admin);
    }
    @PostMapping("/update/admin")
    public String updateAdmin(@ModelAttribute("adminBean") Admin admin){
        dao.save(admin);
        return "redirect:/adminview";
    }

}
