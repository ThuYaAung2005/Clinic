package com.project.clinic.clinic.controllers;


import com.project.clinic.clinic.daos.BookingDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Booking;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingDao dao;

    @GetMapping("/bookingcreate")
    public ModelAndView getBooking(){

        return new ModelAndView("/booking/bookingcreate", "booking",new Booking());
    }

    @GetMapping("/bookingview")
    public String bookingView(Model model){
        List <Booking> bookings= dao.findAll();
        model.addAttribute("booking",bookings);
        return "/booking/bookingview";
    }
    @PostMapping ("bookingcreate")
    public ModelAndView postBooking(@ModelAttribute("booking") Booking booking){
        Patient patient = new Patient();
        patient.setPatient_id(1L);

        Doctor doctor = new Doctor();
        doctor.setDoctor_id(1L);

        booking.setPatients(patient);
        booking.setDoctor(doctor);

        dao.save(booking);

        return new ModelAndView("redirect:/bookingview");
    }



}
