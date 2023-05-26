package com.example.registrationlogindemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String loginForm(Model model, HttpSession httpSession) {
        model.addAttribute("session", httpSession);
        return "login";
    }

    @GetMapping({ "/index", "/"})
    public String home(Model model){
        SecurityContext securityContext = SecurityContextHolder.getContext();
        UserDetails user = (UserDetails) securityContext.getAuthentication().getPrincipal();
        //model.addAttribute("session", username);
        return "index";
    }


}
