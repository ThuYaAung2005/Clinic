package com.project.clinic.clinic.controllers;

import com.project.clinic.clinic.daos.StuffDao;
import com.project.clinic.clinic.models.Stuff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Base64;

@Controller
public class StuffController {

    @Autowired
    StuffDao stuffDao;


    @GetMapping("/stuff/create")
    public ModelAndView getStuff(){
         return new ModelAndView("/stuff/stuffcreate","stuff",new Stuff());
    }

    @PostMapping("/create")
    public ModelAndView postStuff(@ModelAttribute("stuff") Stuff stuff, @RequestParam("image")MultipartFile image, RedirectAttributes redirectAttributes){
        byte[] bytes = new byte[0];
        try {
            bytes = image.getBytes();
            String encodedString = Base64.getEncoder().encodeToString(bytes);
            stuff.setImage(encodedString);
            String encodepassword= BCrypt.hashpw(stuff.getPassword(),BCrypt.gensalt());
            stuff.setPassword(encodepassword);
            stuffDao.save(stuff);
        } catch (IllegalArgumentException | IOException e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("redirect:/");
    }
}
