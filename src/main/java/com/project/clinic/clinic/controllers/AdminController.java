package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.AdminDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Patient;
import jakarta.servlet.http.HttpSession;
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
    public ModelAndView adminCreateGet(HttpSession session){

        return new ModelAndView("/admin/admincreate","admin",new Admin());
    }

    @PostMapping("/admincreate")
    public ModelAndView adminCreatePost(@ModelAttribute Admin admin, HttpSession session){

        dao.save(admin);
        return new ModelAndView("redirect:/adminview");
    }
    @GetMapping("/adminview")
    public String adminview(Model model){
        List<Admin> admins=dao.findAll();
        model.addAttribute("admins",admins);
        return "/admin/adminview";
    }

    @GetMapping("/delete/admin/{admin_id}")
    public String deleteadmin(@PathVariable("admin_id") Long admin_id){
      dao.deleteById(admin_id);
     return  "redirect:/adminview";
    }

    @GetMapping("/admin/edit/{admin_id}")
    public ModelAndView adminedit(@PathVariable("admin_id") Long admin_id){
        Admin admin =dao.findById(admin_id).orElseThrow();
        return new ModelAndView("/admin/adminedit","admin",admin);
    }
    @PostMapping("/admin/update")
    public String updateAdmin(@ModelAttribute("admin") Admin admin){
        dao.save(admin);
        return "redirect:/adminview";
    }

}
