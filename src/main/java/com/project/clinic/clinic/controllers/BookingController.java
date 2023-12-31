package com.project.clinic.clinic.controllers;


import com.project.clinic.clinic.daos.BookingDao;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.dto.BookingDto;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Booking;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.Doc;
import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingDao dao;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    HttpSession session;
    @Autowired
    PatientDao patientDao;

    @GetMapping("/bookingcreate")
    public ModelAndView getBooking(Model model){
        Patient checkPatient =(Patient) session.getAttribute("patient");
        if (checkPatient == null){
            return new ModelAndView("redirect:/login");
        }
        List<Doctor> doctors= doctorDao.findAll();
        model.addAttribute("doctors",doctors);
        return new ModelAndView("/booking/bookingcreate", "bookingdto",new BookingDto());
    }

    @PostMapping ("bookingcreate")
    public ModelAndView postBooking(@ModelAttribute("bookingdto") BookingDto bookingDto, RedirectAttributes redirectAttributes) {
        Patient checkPatient =(Patient) session.getAttribute("patient");
        if (checkPatient == null){
            return new ModelAndView("redirect:/login");
        }

        Patient patient = patientDao.findById(checkPatient.getPatient_id()).get();
        Booking booking = new Booking();
        Doctor doctor = doctorDao.findById(bookingDto.getDoctorId()).get();
        booking.setPatients(patient);
        booking.setDoctor(doctor);
        System.out.println(bookingDto.getDoctorId());
        dao.save(booking);
        return new ModelAndView("redirect:/bookingviewforpatient");
    }


//    @GetMapping("/bookingview")
//    public String doctorView(Model model) {
//        Doctor doctor = (Doctor) session.getAttribute("doctor");
//        Admin admin = (Admin) session.getAttribute("admin");
//        if  ( admin == null ){
//            return "redirect:/login";
//        }
//        List<Booking> bookings = dao.findAll();
//        model.addAttribute("bookings", bookings);
//        return "/booking/bookingview";
//    }

}

