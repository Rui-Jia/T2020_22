package com.group22.techtrek.controller;

import org.springframework.web.bind.annotation.RestController;

import com.group22.techtrek.model.User;
import com.group22.techtrek.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class APIController {

    @Autowired
    UserService userService;
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public User getCustomerIds(@RequestBody User user) {
        System.out.println("Inside get Id");
        
        User userDetails = userService.getFullUserDetails(user);

        return userDetails;
    }
    
}