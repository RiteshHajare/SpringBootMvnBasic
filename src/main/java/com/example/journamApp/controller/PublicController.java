package com.example.journamApp.controller;

import com.example.journamApp.entity.UserEntry;
import com.example.journamApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserService userService;
    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }

    @PostMapping("/create-user")
    public void setuser(@RequestBody UserEntry user){
        userService.saveEntry(user);
    }
}
