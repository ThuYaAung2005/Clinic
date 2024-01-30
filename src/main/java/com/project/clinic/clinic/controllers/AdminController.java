package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.*;
import com.project.clinic.clinic.dto.BookingDto;
import com.project.clinic.clinic.models.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.Doc;
import java.util.List;
@Controller
public class AdminController {
    @Autowired
    AdminDao dao;
    @Autowired
    DoctorDao doctorDao;
    @Autowired
    PatientDao patientDao;
    @Autowired
    BookingDao bookingDao;
    @Autowired
    DoctorScheduleDao doctorScheduleDao;
    @Autowired
    HttpSession session;

    @GetMapping("adminacc")
    public String adminacc(){
        return "/admin/adminacc";
    }

    @GetMapping("/admincreate")
    public ModelAndView adminCreateGet() {

        return new ModelAndView("/admin/admincreate", "admin", new Admin());
    }
    @PostMapping("/admincreate")
    public ModelAndView adminCreatePost(@ModelAttribute("admin") Admin admin, Model model, RedirectAttributes redirectAttributes){
        String encodepassword1=BCrypt.hashpw(admin.getPassword(),BCrypt.gensalt());
        admin.setPassword(encodepassword1);
        Admin adminQuery=dao.checkAdminQuery(admin.getAdmin_id());
        if (adminQuery == null) {
//            model.addAttribute("adminname",admin.getAdmin_name());
            admin.setRoles("admin");
            dao.save(admin);
            redirectAttributes.addFlashAttribute("logout", "Admin Create Successful");
            return new ModelAndView("/admin/admindashboard");
        }else{
            redirectAttributes.addFlashAttribute("error","admin already exit");
            return  new ModelAndView("redirect:/admincreate");
        }
    }

        @GetMapping("/adminview")
        public String adminview (Model model, HttpSession session){
            Admin checkAdmin = (Admin) session.getAttribute("admin");
            if (checkAdmin == null) {
                return "redirect:/login";
            }
            List<Admin> admins = dao.findAll();
            model.addAttribute("admins", admins);
            return "/admin/adminview";
        }

//        @GetMapping("/delete/admin/{admin_id}")
//        public String deleteadmin (@PathVariable("admin_id") Long admin_id, HttpSession session){
//            Admin checkAdmin = (Admin) session.getAttribute("admin");
//            if (checkAdmin == null) {
//                return "redirect:/login";
//            }
//            dao.deleteById(admin_id);
//            return "redirect:/adminview";
//        }

        @GetMapping("/admin/edit/{admin_id}")
        public ModelAndView adminedit (@PathVariable("admin_id") Long admin_id, HttpSession session){
            Admin checkAdmin = (Admin) session.getAttribute("admin");
            if (checkAdmin == null) {
                return new ModelAndView("redirect:/login");
            }

            Admin admin = dao.findById(admin_id).orElseThrow();
            return new ModelAndView("/admin/adminedit", "admin", admin);
        }
        @PostMapping("/admin/update")
        public String updateAdmin (@ModelAttribute("admin") Admin admin){
            String encodepassword = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
            admin.setPassword(encodepassword);
            dao.save(admin);
            return "redirect:/adminview";
        }
        @GetMapping("doctorviewforadmin")
        public String doctorViewForAdmin(Model model){
            Admin admin=(Admin) session.getAttribute("admin");
            if (admin ==null){
                return ("redirect:/login");
            }
            List<Doctor> doctors = doctorDao.findAll();
            model.addAttribute("doctors", doctors);
            return "/admin/doctorviewforadmin";
        }
        @GetMapping("patientviewforadmin")
        public  String patientViewForAdmin(Model model){
            Admin checkAdmin = (Admin) session.getAttribute("admin");
            if (checkAdmin == null) {
                return ("redirect:/login");
            }
            List<Patient> patients = patientDao.findAll();
            model.addAttribute("patients",patients);
            return "/admin/patientviewforadmin";
        }
        @GetMapping("bookingviewforadmin")
        public String bookingViewForAdmin(Model model){
            Admin checkAdmin = (Admin) session.getAttribute("admin");
            if (checkAdmin == null) {
                return ("redirect:/login");
            }
            List<Booking> bookings = bookingDao.findAll();
//            List<Patient> patients=patientDao.findAll();
            model.addAttribute("bookings", bookings);
            return "/admin/bookingviewforadmin";
        }


    @GetMapping("admin/patient/edit/{patient_id}")
    public ModelAndView editPatient(@PathVariable("patient_id")Long patient_id,HttpSession session){
        Admin checkAdmin =(Admin) session.getAttribute("admin");
        if (checkAdmin == null){
            return new ModelAndView("redirect:/login");
        }
        Patient patient =patientDao.findById(patient_id).orElseThrow();
        return new ModelAndView("/patient/patientedit","patientBean",patient);
    }
    @PostMapping("admin/patient/update")
    public String updatePatient(@ModelAttribute("patientBean")Patient patient){
        String encodepassword= BCrypt.hashpw(patient.getPassword(),BCrypt.gensalt());
        patient.setPassword(encodepassword);
        patientDao.save(patient);
        return "redirect:/patientviewforadmin";
    }
//    @GetMapping("admin/delete/patient/{patient_id}")
//    public String deletePatient(@PathVariable("patient_id")Long patient_id, HttpSession session){
//        Admin admin=(Admin) session.getAttribute("admin");
//        if (admin ==null){
//            return "redirect:/login";
//        }
//        dao.deleteById(patient_id);
//        return  "redirect:/patientviewforadmin";
//    }
@GetMapping("/doctorscheduleviewforadmin")
public String doctorScheduleView(Model model, HttpSession session) {
    Admin admin=(Admin) session.getAttribute("admin");
    if (admin ==null){
        return ("redirect:/login");
    }
    List<DoctorSchedule> docSchedules = doctorScheduleDao.findAll();
    model.addAttribute("docSchedules", docSchedules);
    return "/admin/doctorscheduleviewforadmin";
}
    }
