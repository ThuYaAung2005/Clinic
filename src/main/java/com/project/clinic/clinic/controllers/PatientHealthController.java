package com.project.clinic.clinic.controllers;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import com.project.clinic.clinic.daos.BookingDao;
import com.project.clinic.clinic.daos.DoctorDao;
import com.project.clinic.clinic.daos.PatientDao;
import com.project.clinic.clinic.daos.PatientHealthDao;
import com.project.clinic.clinic.models.Booking;
import com.project.clinic.clinic.models.Doctor;
import com.project.clinic.clinic.models.Patient;
import com.project.clinic.clinic.models.PatientHealth;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

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
    @Autowired
    PatientHealthDao patientHealthDao;
    @GetMapping("/patienthealth/{patient_id}")
    public ModelAndView patienthealthcreate(@PathVariable("patient_id")long patient_id){
        Doctor doctor=(Doctor) session.getAttribute("doctor");
        System.out.println(doctor.getName());
        System.out.println(patient_id);
        Patient patient=new Patient();
        patient.setPatient_id(patient_id);
        PatientHealth patientHealth= new PatientHealth();
        patientHealth.setPatient(patient);
        return new ModelAndView("/patienthealth/patientH","patienthealth", patientHealth);
        ///patienthealth/patienthealthcreate
    }
    @PostMapping("/patienthealth")
    public String postpatienthealth(@ModelAttribute("patienthealth")PatientHealth patientHealth){
        Doctor doctorsession=(Doctor) session.getAttribute("doctor");
        Patient patient =patientDao.findById(patientHealth.getPatient().getPatient_id()).get();
        Doctor doctor= doctorDao.findById(doctorsession.getDoctor_id()).get();
        PatientHealth patientHealthforsave =new PatientHealth();
        patientHealthforsave.setPatient(patient);
        patientHealthforsave.setDoctor(doctor);
        patientHealthforsave.setDisease(patientHealth.getDisease());
        patientHealthDao.save(patientHealthforsave);
        return "redirect:/bookingviewfordoctor";
    }

    @GetMapping("/patienthealthviewfordoctor")
    public String patienthealthviewForDoctor(Model model){

        List<PatientHealth> patientHealths=patientHealthDao.findAll();
        patientHealths = isLoginIsDoctor() ? filterPatientHealthListByDoctor(patientHealths,getLoginDoctor()):patientHealths;
        model.addAttribute("patientHealths",patientHealths);
        return "/doctor/phviewfordoctor";
    }

    private List<PatientHealth> filterPatientHealthListByDoctor(List<PatientHealth> patientHealths, Doctor checkDoctor){
        List<PatientHealth> newPatientHealth= new ArrayList<>();
        for(PatientHealth p: patientHealths){
            if(p.getDoctor().getDoctor_id().equals(checkDoctor.getDoctor_id())){
                newPatientHealth.add(p);
            }
        }
        return newPatientHealth;
    }
    private  boolean isLoginIsDoctor(){
        Doctor checkDoctor =(Doctor) session.getAttribute("doctor");
        return checkDoctor !=null;
    }
    private Doctor getLoginDoctor(){
        return (Doctor) session.getAttribute("doctor");
    }

    private List<PatientHealth> filterPatientHealthListByPatient(List<PatientHealth> patientHealths,Patient checkPatient){
        List<PatientHealth> newPatientHealth= new ArrayList<>();
        for(PatientHealth p: patientHealths){
            if(p.getPatient().getPatient_id().equals(checkPatient.getPatient_id())){
                newPatientHealth.add(p);
            }
        }
        return newPatientHealth;
    }

    @GetMapping("/patienthealthviewforpatient")
    public String patienthealthview(Model model){
        List<PatientHealth> patientHealths=patientHealthDao.findAll();
        patientHealths = isLoginIsPatient() ? filterPatientHealthListByPatient(patientHealths,getLoginPateint()):patientHealths;
        model.addAttribute("patientHealths",patientHealths);
        return "/patienthealth/phview";
    }
    private  boolean isLoginIsPatient(){
        Patient checkPatient =(Patient) session.getAttribute("patient");
        return checkPatient !=null;
    }
    private Patient getLoginPateint(){
        return (Patient) session.getAttribute("patient");
    }
}