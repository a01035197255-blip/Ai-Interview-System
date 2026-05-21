package com.ai.interview.controller;

import com.ai.interview.entity.Question;
import com.ai.interview.service.QuestionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create")
    public Question createQuestion(
            @RequestParam Long sessionId,
            @RequestParam String text
    ) {
        return questionService.createQuestion(sessionId, text);
    }

    @GetMapping("/{sessionId}")
    public List<Question> getQuestions(@PathVariable Long sessionId) {
        return questionService.getQuestionsBySession(sessionId);
    }
}