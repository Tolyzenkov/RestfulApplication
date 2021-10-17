package com.example.restfulapplication.service;

import com.example.restfulapplication.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface UserService {
    User findByLogin(String login);
    void addNewUser(User user);
    List<User> findAllUsers();
    void deleteUserByLogin(String login);
    void updateUser(User user);
}
