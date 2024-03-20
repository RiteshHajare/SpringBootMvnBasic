package com.example.journamApp.controller;


import com.example.journamApp.entity.UserEntry;
import com.example.journamApp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserEntry> users(){
        return userService.getAll();
    }



    @PutMapping()
    public UserEntry updateUser(@RequestBody UserEntry user){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        UserEntry gotUser = userService.findByUsername(username);
        if(gotUser!=null){
            gotUser.setUsername(user.getUsername());
            gotUser.setPassword(user.getPassword());
            userService.saveNewEntry(gotUser);
        }
        return gotUser;
    }

}
