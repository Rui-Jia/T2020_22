package com.group22.techtrek.controller;

import java.util.ArrayList;
import java.util.List;

import com.group22.techtrek.model.Marketing;
import com.group22.techtrek.model.User;
import com.group22.techtrek.service.MarketingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class IndexController {
    
    @Autowired
    MarketingService userService;
    
    @RequestMapping(value="/login", method=RequestMethod.GET)
    public List<Marketing> getCustomerIds(@RequestBody User user) {
        System.out.println("Inside get Id");
        List<Marketing> marketingList = new ArrayList<>();

        return marketingList;
    }
    
}
