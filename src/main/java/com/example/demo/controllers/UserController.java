package com.example.demo.controllers;

import com.example.demo.dao.UserDAO;
import com.example.demo.models.User;
import com.example.demo.services.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:4200"})
@AllArgsConstructor
@RequestMapping("/users")

public class UserController {


    private UserDAO userDAO;
    private MailService mailService;


    @GetMapping("")
    public List<User> users() {
        List<User> users = userDAO.findAll();
        return users;
    }

    @PostMapping("/registration")
    public  void userRegistration (@RequestBody User user) {
        System.out.println(user);
        userDAO.save(user);
        mailService.sendMyMessage(user);
    }

    @GetMapping("/activate/{id}")
    public void activateUser(@PathVariable int id) {
        User user = userDAO.getById(id);
        user.setActivated(true);
        userDAO.save(user);
    }
    @PostMapping("")
    public User saveUser(@RequestBody User user) {
        userDAO.save(user);

        //todo send email
        //1. add lib
        //2. service
        //3. config prop file
        return user;
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable int id) {
        return userDAO.findById(id).get();
    }

    @PatchMapping("")
    public User updateUser(@RequestBody User userFromrequest) {
        User userFromDb = userDAO.getById(userFromrequest.getId());
        userDAO.save(userFromrequest);
        return userFromrequest;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userDAO.deleteById(id);
    }

}
