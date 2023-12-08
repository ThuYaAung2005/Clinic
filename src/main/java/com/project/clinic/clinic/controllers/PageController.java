package com.project.clinic.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class PageController {
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "sigin";
    }

    @GetMapping("/adminlogin")
    public String adminLogin(){
        return "admin/adminlogin";
    }
    @GetMapping("/doctorlogin")
    public String doctorLogin(){
        return "doctor/doctorlogin";
    }
    @GetMapping("/patientlogin")
    public String patientLogin(){
        return "patient/patientlogin";
    }

    @GetMapping("/test")
    public String testshow(){
        return "payment/sidebar";
    }
}

