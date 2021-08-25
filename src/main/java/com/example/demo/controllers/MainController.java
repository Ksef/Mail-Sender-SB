package com.example.demo.controllers;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
public class MainController {

    private UserDAO userDAO;

    public MainController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/users")
    public List<User> users() {
        List<User> all = userDAO.findAll();
        return all;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody User user) {
        System.out.println(user);
        userDAO.save(user);

    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = userDAO.findById(id).get();
        return user;
    }
}

