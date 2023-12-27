package com.project.clinic.clinic.controllers;


import com.project.clinic.clinic.daos.BookingDao;
import com.project.clinic.clinic.daos.PatientDao;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {

    @Autowired
    BookingDao dao;

    @GetMapping("/bookingcreate")
    public ModelAndView getBooking(HttpSession session){
//        Patient checkPatient =(Patient) session.getAttribute("patient");
//        if (checkPatient == null){
//            return new ModelAndView("redirect:/login");
//        }
        return new ModelAndView("/booking/bookingcreate", "booking",new Booking());
    }

    @GetMapping("/bookingview")
    public String bookingView(Model model,HttpSession session){
        Patient checkPatient =(Patient) session.getAttribute("patient");
        List <Booking> bookings= dao.findAll();
        List<Booking > newBooking=new ArrayList<>();
        for(Booking b: bookings){
          if(b.getPatients().getPatient_id().equals(checkPatient.getPatient_id())) {
              newBooking.add(b);
          }
        }
        model.addAttribute("booking",newBooking);
        return "/booking/bookingview";
    }

    @PostMapping ("bookingcreate")
    public ModelAndView postBooking(@ModelAttribute("booking") Booking booking, HttpSession session){
//        Patient checkPatient=(Patient) session.getAttribute("patient");
//        if (checkPatient==null){
//            return new ModelAndView("redirect:/login");
//        }
//        Patient patient = new Patient();
//        patient.setPatient_id(1L);
//
//        Doctor doctor = new Doctor();
//        doctor.setDoctor_id(1L);
//
//        booking.setPatients(patient);
//        booking.setDoctor(doctor);
        dao.save(booking);
        return new ModelAndView("redirect:/bookingview");
    }
}
