package com.example.restfulapplication.service;

import com.example.restfulapplication.model.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    User findByLogin(String login);
    void addNewUser(User user);
    List<User> findAllUsers();
    void deleteUserByLogin(String login);
    void updateUser(User user);
}
