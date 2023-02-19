package com.onboarding.controllers;

import com.onboarding.entity.AnswerEntity;
import com.onboarding.entity.Lesson;
import com.onboarding.entity.QuestionEntity;
import com.onboarding.entity.Subdivision;
import com.onboarding.repository.AnswerRepository;
import com.onboarding.repository.LessonRepository;
import com.onboarding.repository.QuestionRepository;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/questions")
public class QuestionController {
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;
    private final LessonRepository lessonRepository;
    @GetMapping("lesson/{id}")
    public String getQuestions(@PathVariable(value = "id") long id, Model model) {
        Lesson lesson = lessonRepository.findById(id);
        model.addAttribute("questions",lesson.getQuestions());
        return "questions";
    }

    @GetMapping("/newquestion")
    public String newQuestion(Model model) {
        model.addAttribute("newQue", new QuestionEntity());
        return "newQue";
    }
    @PostMapping
    public String createQuestion(@ModelAttribute("question") QuestionEntity offer){
        questionRepository.save(offer);
        return "redirect:/";
    }



}
