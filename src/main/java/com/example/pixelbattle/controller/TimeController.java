package com.example.pixelbattle.controller;

import com.example.pixelbattle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

@Controller
public class TimeController {

//    @Autowired
//    private UserRepository userRepository;
//
//    @MessageMapping("/qwe")
//    @SendTo("/time-topic/getLastClickDate")
//    Date getLastClickDate(Principal principal) {
//        System.out.println(123123123);
//        if(principal == null)
//            return new Date();
//        return userRepository.findByUsername(principal.getName()).getLastClickDate();
//    }
}
