package com.onboarding.controllers;


import com.onboarding.entity.Course;
import com.onboarding.entity.Lesson;
import com.onboarding.repository.CourseRepository;
import com.onboarding.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private final LessonRepository lessonRepository;


    public LessonController(CourseRepository courseRepository, LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }
    @GetMapping("/new")
    public String newSub(Model model) {
        model.addAttribute("newLesson", new Lesson());
        return "newLesson";
    }

    @PostMapping
    public String saveSub(@ModelAttribute("newLesson") Lesson lesson) {
        lessonRepository.save(lesson);
        return "redirect:/home";
    }
}
