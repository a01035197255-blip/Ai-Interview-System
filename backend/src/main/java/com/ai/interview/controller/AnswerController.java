package com.ai.interview.controller;

import com.ai.interview.entity.Answer;
import com.ai.interview.service.AnswerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping("/submit")
    public Answer submitAnswer(
            @RequestParam Long questionId,
            @RequestParam String answerText
    ) {
        return answerService.saveAnswer(questionId, answerText);
    }

    @GetMapping("/list")
    public List<Answer> getAnswers() {
        return answerService.getAnswers();
    }
}