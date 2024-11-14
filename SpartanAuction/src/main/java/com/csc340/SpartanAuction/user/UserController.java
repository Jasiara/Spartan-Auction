package com.csc340.SpartanAuction.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

/**
 * UserController.java.
 * Includes all REST API endpoint mappings for the Student object.
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getOneUser(@PathVariable int id) {
        return service.getUserById(id);
    }

    /*@GetMapping("")
    public List<User> getUsersBy______(@RequestParam(name = "major", defaultValue = "csc") String major) {
        return service.getUsersBy_____(major);
    }*/


    /*@GetMapping("/honors")
    public List<User> get_____Users(@RequestParam(name = "gpa", defaultValue = "3.0") double gpa) {
        return service.get____Users(gpa);
    }*/


    @PostMapping("/new")
    public String addNewUser(@ModelAttribute("user") User user) {
        service.addNewUser(user);
        return "redirect:profile/" + user.getId();
    }

    @GetMapping("/test")
    public String test(Model model) {
        return "index";
    }

    @GetMapping("/createUserForm")
    public String showNewUserForm(Model model) {
        User user = new User();


        return "login";
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        service.updateUser(id, user);
        return service.getUserById(id);
    }


    @DeleteMapping("/delete/{id}")
    public List<User> deleteUserById(@PathVariable int id) {
        service.deleteUserById(id);
        return service.getAllUsers();
    }
}