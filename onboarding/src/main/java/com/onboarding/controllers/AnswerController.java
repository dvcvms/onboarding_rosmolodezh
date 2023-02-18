package com.onboarding.controllers;

import com.onboarding.entity.AnswerEntity;
import com.onboarding.entity.QuestionEntity;
import com.onboarding.entity.Status;
import com.onboarding.repository.AnswerRepository;
import com.onboarding.repository.QuestionRepository;
import com.onboarding.repository.StatusRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/ans")
@Controller
public class AnswerController {


        private final AnswerRepository answerRepository;
        private  final QuestionRepository questionRepository;

    public AnswerController(AnswerRepository answerRepository, QuestionRepository questionRepository) {
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }


    @GetMapping("question/{id}")
    public String getAnswers(@PathVariable(value = "id") long id, Model model) {
        QuestionEntity question = questionRepository.findById(id);
        model.addAttribute("question", question);
        model.addAttribute("answers", question.getAnswers());
        return "answers";
    }
    @GetMapping("/newanswer")
    public String newSub(Model model) {
        model.addAttribute("newAns", new AnswerEntity());
        return "newAns";
    }
    @PostMapping
    public String createAnswer(@ModelAttribute("newAns") AnswerEntity answer){
        answerRepository.save(answer);
        return "redirect:/";
    }
}
