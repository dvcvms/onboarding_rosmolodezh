package com.onboarding.controllers;

import com.onboarding.entity.AnswerEntity;
import com.onboarding.entity.QuestionEntity;
import com.onboarding.repository.AnswerRepository;
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
    @GetMapping("allquestions/{id}")
    public String getQuestions(@PathVariable(value = "id") long id, Model model) {
        model.addAttribute("questions", questionRepository.findAll());
        model.addAttribute("question" , new QuestionEntity());
        return "questions";
    }
    @GetMapping("allanswers/{id}")
    public String getAnswers(@PathVariable(value = "id") long id, Model model) {
        Optional question = questionRepository.findById(id);
        model.addAttribute("question", question;
        model.addAttribute("answers", question.getAnswers()));
        model.addAttribute("answer" , new AnswerEntity());
        return "answers";
    }
    @PostMapping
    public String createNewOffer(@ModelAttribute("question") QuestionEntity offer){
        questionRepository.save(offer);
        return "redirect:/";
    }
    @PostMapping
    public String createNewOffer(@ModelAttribute("answer") AnswerEntity offer){
        answerRepository.save(offer);
        return "redirect:/";
    }


}
