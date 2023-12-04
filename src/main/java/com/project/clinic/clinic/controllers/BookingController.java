package com.project.clinic.clinic.controllers;


import com.project.clinic.clinic.daos.BookingDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Booking;
import com.project.clinic.clinic.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingDao dao;



    @GetMapping("/bookingcreate")
    public String getBooking(){
        return "/booking/bookingcreate";
    }

    @GetMapping("/bookingview")
    public String bookingView(Model model){
        List <Booking> booking = dao.findAll();
        model.addAttribute("booking",booking);
        return "/booking/bookingview";
    }



}
