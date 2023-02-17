package com.onboarding.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {

    @GetMapping("/home")
    public String home( Model model) {
        model.addAttribute("title", "Главная сттраница");
        return "home";
    }

}