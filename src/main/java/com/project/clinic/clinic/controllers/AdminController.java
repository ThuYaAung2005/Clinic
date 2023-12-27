package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.AdminDao;
import com.project.clinic.clinic.models.Admin;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;
@Controller
public class AdminController {
    @Autowired
    AdminDao dao;
    @GetMapping("/admincreate")
    public ModelAndView adminCreateGet() {

        return new ModelAndView("/admin/admincreate", "admin", new Admin());
    }
    @PostMapping("/admincreate")
    public ModelAndView adminCreatePost(@ModelAttribute Admin admin,RedirectAttributes redirectAttributes){
        String encodepassword1=BCrypt.hashpw(admin.getPassword(),BCrypt.gensalt());
        admin.setPassword(encodepassword1);
        redirectAttributes.addFlashAttribute("adminname",admin.getAdmin_name());
        dao.save(admin);

        return new ModelAndView("redirect:/admin/admindashboard");
    }

        @GetMapping("/adminview")
        public String adminview (Model model, HttpSession session){
            Admin checkAdmin = (Admin) session.getAttribute("admin");
            if (checkAdmin == null) {
                return "redirect:/login";
            }
            List<Admin> admins = dao.findAll();
            model.addAttribute("admins", admins);
            return "/admin/adminview";
        }

        @GetMapping("/delete/admin/{admin_id}")
        public String deleteadmin (@PathVariable("admin_id") Long admin_id, HttpSession session){
            Admin checkAdmin = (Admin) session.getAttribute("admin");
            if (checkAdmin == null) {
                return "redirect:/login";
            }
            dao.deleteById(admin_id);
            return "redirect:/adminview";
        }

        @GetMapping("/admin/edit/{admin_id}")
        public ModelAndView adminedit (@PathVariable("admin_id") Long admin_id, HttpSession session){
            Admin checkAdmin = (Admin) session.getAttribute("admin");
            if (checkAdmin == null) {
                return new ModelAndView("redirect:/login");
            }

            Admin admin = dao.findById(admin_id).orElseThrow();
            return new ModelAndView("/admin/adminedit", "admin", admin);
        }
        @PostMapping("/admin/update")
        public String updateAdmin (@ModelAttribute("admin") Admin admin){
            String encodepassword = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
            admin.setPassword(encodepassword);
            dao.save(admin);
            return "redirect:/adminview";
        }
    }
