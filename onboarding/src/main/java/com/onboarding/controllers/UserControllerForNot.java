package com.onboarding.controllers;

import com.onboarding.entity.Notification;
import com.onboarding.entity.User;
import com.onboarding.repository.NotificationRepository;
import com.onboarding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/userNotes")
public class UserControllerForNot {
    private final NotificationRepository notificationRepository;
    private final UserRepository userRepository;
    @GetMapping("/new/notification")
    public String homePage(Model model){
        model.addAttribute("newNotification", new Notification());
        return "newNotification";
    }

    @PostMapping
    public String save(@ModelAttribute("newNotification") Notification notification){
        notificationRepository.save(notification);
        User user = userRepository.findUserByUserId(notification.getUserId());
        user.addNotification(notification);
        return "redirect:/home";
    }
}
