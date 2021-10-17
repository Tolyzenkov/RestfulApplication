package com.example.restfulapplication.controllers;


import com.example.restfulapplication.model.User;
import com.example.restfulapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/admin")
    public String usersList(ModelMap model, Principal principal) {
        System.out.println(principal.getName());
        User user = userService.findByLogin(principal.getName());
        String msg = "Hello " + user.getUsername();
        model.addAttribute("msg", msg);
        return "index";
    }
}
