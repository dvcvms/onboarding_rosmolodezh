package com.onboarding.controllers;

import com.onboarding.entity.Notification;
import com.onboarding.entity.Subdivision;
import com.onboarding.entity.User;
import com.onboarding.repository.NotificationRepository;
import com.onboarding.repository.SubdivisionRepository;
import com.onboarding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/user")
@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final SubdivisionRepository subdivisionRepository;
    private final NotificationRepository notificationRepository;

    @GetMapping("/amogus")
    public String Am(Model model) {
        return "SuccessPage";
    }

    @GetMapping("/view/{id}")
    public String viewUsers(@PathVariable("id") long userId, Model model) {
        User user = userRepository.findById(userId);
        if (user != null) {
            model.addAttribute("name", user.getName());
        }

        model.addAttribute("sub", user.getSubdivision().getName());
        model.addAttribute("notifications", user.getNotificationList().toString());
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
