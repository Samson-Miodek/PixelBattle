package com.example.pixelbattle.controller;

import com.example.pixelbattle.entity.User;
import com.example.pixelbattle.entity.secutiry.Authority;
import com.example.pixelbattle.repository.UserRepository;
import com.example.pixelbattle.secutiry.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Date;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("register")
    public String registerPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("register")
    public String register(@ModelAttribute User user){

        if(userRepository.findByUsername(user.getUsername()) != null)
            return "redirect:register?error";

        user.setActive(1);
        user.setAuthorities(Collections.singleton(Authority.ROLE_USER));
        user.setPassword(SecurityConfiguration.passwordEncoder().encode(user.getPassword()));
        user.setLastClickDate(new Date());
        userRepository.save(user);

        return "index";
    }

    @GetMapping("login")
    public String login(){return "login";}

}
