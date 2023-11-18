package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DoctorController {
    @Autowired
    DoctorDao dao;

}
