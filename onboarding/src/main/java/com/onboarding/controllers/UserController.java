package com.onboarding.controllers;

import com.onboarding.entity.User;
import com.onboarding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
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

    @GetMapping("/view/{id}")
    public String viewUsers(@PathVariable("id") long userId, Model model) {
        User user = userRepository.findById(userId);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "viewUsers";
    }

    @GetMapping("/save")
    public String newUser(Model model) {
        model.addAttribute("newUser", new User());
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("newUser") User user) {
        userRepository.save(user);
        return "redirect:/home";
    }
}
