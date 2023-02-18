package com.onboarding.controllers;

import com.onboarding.entity.Course;
import com.onboarding.entity.Subdivision;
import com.onboarding.entity.User;
import com.onboarding.repository.CourseRepository;
import com.onboarding.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/net")
@Controller
public class NetworkController {
    private final UserRepository userRepository;
    private final CourseRepository courseRepository;

    public NetworkController(UserRepository userRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }
    @GetMapping("/{course_id}/{id}")
    public String newSub(@PathVariable("id") long userId, @PathVariable("course_id") long courseId, Model model) {
        User user = userRepository.findById(userId);
        Course course = courseRepository.findById(courseId);
        user.addCourse(course);
        userRepository.save(user);
        return "redirect:/home";
    }


    }

