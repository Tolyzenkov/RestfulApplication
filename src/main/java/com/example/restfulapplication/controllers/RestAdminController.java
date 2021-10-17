package com.example.restfulapplication.controllers;

import com.example.restfulapplication.model.User;
import com.example.restfulapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
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

    @GetMapping("/{login}")
    public User getUser(@PathVariable("login") String login) {
        return userService.findByLogin(login);
    }

    @PostMapping
    public String create(@RequestBody @Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return  "success: " + false + "," +
                    bindingResult.getAllErrors();
        }
        userService.addNewUser(user);
        return "success: " + true;
    }

    @PatchMapping("/edit")
    public String update(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return  "success: " + false + "," +
                    bindingResult.getAllErrors();
        }
        userService.updateUser(user);
        System.out.println(user.toString());
        return "success: " + true;
    }

    @DeleteMapping("/delete/{login}")
    public List<User> delete(@PathVariable("login") String userName) {
        userService.deleteUserByLogin(userName);
        return userService.findAllUsers();
    }

}
