package com.onboarding.controllers;


import com.onboarding.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private final CourseRepository courseRepository;


    public LessonController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

}
