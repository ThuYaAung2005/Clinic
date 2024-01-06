package com.project.clinic.clinic.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.project.clinic.clinic.daos.BookingDao;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import com.project.clinic.clinic.models.PatientHealth;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientHealthController {
    @Autowired
    HttpSession session;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    PatientDao patientDao;
    @Autowired
    BookingDao bookingDao;
//    @GetMapping("patienthealth{patient_id}")
//    public ModelAndView patienthealthcreate(@PathVariable("patient_id")long patient_id){
////            return "";
//    }
//}
