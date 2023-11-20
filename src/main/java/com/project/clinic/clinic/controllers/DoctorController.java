package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DoctorController {
    @Autowired
    DoctorDao dao;



}
