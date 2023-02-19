package com.onboarding.controllers;

import com.onboarding.entity.Subdivision;
import com.onboarding.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class TopBarController {




    @GetMapping("/topbar")
    public String newSub(Model model) {
        return "TopBar";
    }


}