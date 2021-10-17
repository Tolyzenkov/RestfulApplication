package com.example.restfulapplication.service;

import com.example.restfulapplication.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
@AutoConfigureMockMvc
class UserServiceImplTest {
    @Autowired
    private UserService userService ;

    private User user;

    @Test
    void addNewUser() {
        user = new User();
        user.setName("Test");
        user.setLogin("Test");
        user.setPassword("1234Abc");
        userService.addNewUser(user);
        Assert.isTrue(user.getLogin().equals("Test"));
    }

    @Test
    void updateUser() {
        addNewUser();
        user.setLogin("TestNew");
        userService.updateUser(user);
        Assert.isTrue(user.getLogin().equals("TestNew"));
    }

    @Test
    void deleteUserByLogin() {
        addNewUser();
        String login = user.getLogin();
        userService.deleteUserByLogin(login);
        Assert.isNull(userService.findByLogin(login));
    }
}