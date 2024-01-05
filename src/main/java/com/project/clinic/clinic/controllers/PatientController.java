package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.BookingDao;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.models.Admin;
import com.project.clinic.clinic.models.Booking;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PatientController {
    @Autowired
    PatientDao dao ;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    HttpSession session;
    @Autowired
    BookingDao bookingDao;
    @GetMapping("/Sigin")
    public ModelAndView sigin() {
        return new ModelAndView("/patient/patientcreate","patient",new Patient());

    }

    @PostMapping("/patientcreate")
    public ModelAndView patientCreatePost(@ModelAttribute  Patient patient,HttpSession session,Model model){
        String encodepassword= BCrypt.hashpw(patient.getPassword(),BCrypt.gensalt());
        patient.setPassword(encodepassword);
        session.setAttribute("patientid", patient);
        patient.setRoles("paitent");
        model.addAttribute("patientname",patient.getPatient_name());
        dao.save(patient);
        return new ModelAndView("/patient/patientdashboard");
    }

    @GetMapping("/patientview")
    public String patientview(Model model,HttpSession session){
        Admin admin=(Admin) session.getAttribute("admin");
        if (admin ==null){
            return "redirect:/login";
        }
        List<Patient> patients = dao.findAll();
        model.addAttribute("patients",patients);
        return "/patient/patientview";
    }


    @GetMapping("/patient/edit/{patient_id}")
    public ModelAndView editPatient(@PathVariable("patient_id")Long patient_id,HttpSession session){
        Admin checkAdmin =(Admin) session.getAttribute("admin");
        if (checkAdmin == null){
            return new ModelAndView("redirect:/login");
        }
        Patient patient =dao.findById(patient_id).orElseThrow();
        return new ModelAndView("/patient/patientedit","patientBean",patient);
    }
    @PostMapping("/patient/update")
    public String updatePatient(@ModelAttribute("patientBean")Patient patient){
        String encodepassword= BCrypt.hashpw(patient.getPassword(),BCrypt.gensalt());
        patient.setPassword(encodepassword);
        dao.save(patient);
        return "redirect:/patientviewforadmin";
    }
    @GetMapping("/patientfordoctorview")
    public String doctorViewForPatient(Model model,HttpSession session) {
        List<Doctor> doctors = doctorDao.findAll();
        model.addAttribute("doctors", doctors);
        return "/patient/patientfordoctorview";
    }
    @GetMapping("/bookingviewforpatient")
    public String bookingView(Model model){
        List <Booking> bookings= bookingDao.findAll();
        bookings = isLoginIsPatient() ? filterBookingListByPatient(bookings,getLoginPateint()): bookings;
        model.addAttribute("bookings",bookings);
        return "/patient/patientbookingview";
    }

    private  boolean isLoginIsPatient(){
        Patient checkPatient =(Patient) session.getAttribute("patient");
        return checkPatient !=null;
    }

    private Patient getLoginPateint(){
        return (Patient) session.getAttribute("patient");
    }

    private List<Booking> filterBookingListByPatient(List<Booking> bookings,Patient checkPatient){
        List<Booking > newBooking=new ArrayList<>();
        for(Booking b: bookings){
            if(b.getPatients().getPatient_id().equals(checkPatient.getPatient_id())) {
                newBooking.add(b);
            }
        }
        return newBooking;
    }
    @GetMapping("/bookingcreate/{doctor_id}")
    public ModelAndView bookingcreate(@PathVariable("doctor_id") Long doctor_id ,Model model) {
        Doctor doctor= doctorDao.findById(doctor_id).orElseThrow();
        model.addAttribute("doctor",doctor);
        return new ModelAndView("/patient/booking");
    }

}
