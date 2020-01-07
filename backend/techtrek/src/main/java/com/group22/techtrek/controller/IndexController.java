package com.group22.techtrek.controller;

import java.util.ArrayList;
import java.util.List;

import com.group22.techtrek.model.Marketing;
import com.group22.techtrek.model.User;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class IndexController {
    
    List<User> userList = new ArrayList<>();

    @PostMapping(value="/login")
    public User login(@RequestBody User user) {
        
        return user;
    }

    //@PostMapping("/")
    
    @GetMapping(value="/marketing")
    public List<Marketing> getMarketingList () {
        List<Marketing> marketingList = new ArrayList<>();
        return marketingList;
    }

}
