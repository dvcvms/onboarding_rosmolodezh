package com.onboarding.controllers;

import com.onboarding.Entity.User;
import com.onboarding.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/amogus")
    public String Am(Model model) {
        return "SuccessPage";
    }

    @GetMapping("/view/user/{id}")
    public String viewUsers(@PathVariable("id") long userId, Model model) {
        User user = userRepository.findUserByUserId(userId);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "viewUsers";
    }

    @GetMapping("/save/user")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("newUser") User user) {
        userRepository.save(user);
        return "redirect:/amogus";
    }
}
