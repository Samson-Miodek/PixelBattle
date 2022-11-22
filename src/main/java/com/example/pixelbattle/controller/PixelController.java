package com.example.pixelbattle.controller;

import com.example.pixelbattle.entity.Pixel;
import com.example.pixelbattle.entity.User;
import com.example.pixelbattle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Date;
import java.util.regex.Pattern;


@Controller
public class PixelController {

    @Autowired
    private UserRepository userRepository;

    private final Pattern hexPattern = Pattern.compile("#[0-9abcdef][0-9aabcdef][0-9aabcdef][0-9aabcdef][0-9aabcdef][0-9aabcdef]$");


    @MessageMapping("/sendPixel")
    @SendTo("/topic/pixels")
    public Pixel pixels(Principal principal, Pixel pixel) {

        if(principal == null)
            return null;

        var color = pixel.getColor();

        if(color == null || pixel.getX() > 5000 || pixel.getX() < -5000 || pixel.getY() > 5000 || pixel.getY() < -5000)
            return null;

        var user = userRepository.findByUsername(principal.getName());

        if(user.getLastClickDate() == null){
            user.setLastClickDate(new Date());
            userRepository.save(user);
        }

        var elapsedSeconds = (new Date().getTime()-user.getLastClickDate().getTime()) / 1000 % 60;

        if(elapsedSeconds > 5 &&  hexPattern.matcher(color).find()) {
            user.setLastClickDate(new Date());
            userRepository.save(user);

            pixel.normalize(10);
            MapController.putCell(pixel.getCoordinates(), color);
        }else{
            return null;
        }



        return pixel;
    }

}

