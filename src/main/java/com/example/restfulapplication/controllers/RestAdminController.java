package com.example.restfulapplication.controllers;

import com.example.restfulapplication.model.User;
import com.example.restfulapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestAdminController {


    private final UserService userService;

    @Autowired
    public RestAdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/admin/{login}")
    public User getUser(@PathVariable("login") String userName) {
        return userService.findByLogin(userName);
    }

    @PostMapping("/admin")
    public List<User> create(@Valid @RequestBody User user) {
        userService.addNewUser(user);
        return userService.findAllUsers();
    }

    @PatchMapping("/admin/edit")
    public List<User> update(@RequestBody User user) {
        userService.updateUser(user);
        System.out.println(user.toString());
        return userService.findAllUsers();
    }

    @DeleteMapping("/admin/delete/{login}")
    public List<User> delete(@PathVariable("login") String userName) {
        userService.deleteUserByLogin(userName);
        return userService.findAllUsers();
    }

}
