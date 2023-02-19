package com.onboarding.controllers;
//TODO: check name controller_S_ (!) -> controller


import com.onboarding.entity.Course;
import com.onboarding.entity.Lesson;
import com.onboarding.entity.Subdivision;
import com.onboarding.repository.CourseRepository;
import com.onboarding.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private final CourseRepository courseRepository;

    @Autowired
    private final LessonRepository lessonRepository;

    public CourseController(CourseRepository courseRepository, LessonRepository lessonRepository) {
        this.courseRepository = courseRepository;
        this.lessonRepository = lessonRepository;
    }

    @GetMapping("/all")
    public String showAllLesson(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return null; // TODO: add html page
    }

    @GetMapping("/{id}/lessons")
    public String showLessonCourses(@PathVariable("id") long id, Model model) {
        List<Lesson> lessonsByCourseId = lessonRepository.findLessonsByCourseId(id);
        model.addAttribute("lessons", lessonsByCourseId);
        return "lessons"; // TODO: add html page
    }
    @GetMapping("/new")
    public String newSub(Model model) {
        model.addAttribute("newCourse", new Course());
        return "newCourse";
    }

    @PostMapping
    public String saveSub(@ModelAttribute("newCourse") Course course) {
        courseRepository.save(course);
        return "redirect:/home";
    }
}
