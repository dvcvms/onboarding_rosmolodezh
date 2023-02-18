package com.onboarding.controllers;

import com.onboarding.entity.Status;
import com.onboarding.entity.Subdivision;
import com.onboarding.repository.StatusRepository;
import com.onboarding.repository.SubdivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/st")
@Controller
public class StatusController  {
    private final StatusRepository  statusRepository;


    @Autowired
    public StatusController(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;


    }



    @GetMapping("/status")
    public String newSub(Model model) {
        model.addAttribute("newStat", new Status());
        return "newStat";
    }

    @PostMapping
    public String saveSub(@ModelAttribute("newStat") Status status) {
        statusRepository.save(status);
        return "redirect:/home";
    }
}
