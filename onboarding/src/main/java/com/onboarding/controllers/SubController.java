package com.onboarding.controllers;

import com.onboarding.entity.Subdivision;
import com.onboarding.entity.User;
import com.onboarding.repository.SubdivisionRepository;
import com.onboarding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/su")
@Controller
public class SubController  {
    private final SubdivisionRepository subdivisionRepository;


    @Autowired
    public SubController( SubdivisionRepository subdivisionRepository) {

        this.subdivisionRepository = subdivisionRepository;
    }



    @GetMapping("/sub")
    public String newSub(Model model) {
        model.addAttribute("newSub", new Subdivision());
        return "newSub";
    }

    @PostMapping
    public String saveSub(@ModelAttribute("newSub") Subdivision subdivision) {
        subdivisionRepository.save(subdivision);
        return "redirect:/home";
    }
}
