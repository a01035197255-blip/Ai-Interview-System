package com.ai.interview.service;

import com.ai.interview.entity.Question;
import com.ai.interview.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Long sessionId, String text) {
        Question q = new Question();
        q.setSessionId(sessionId);
        q.setQuestionText(text);

        return questionRepository.save(q);
    }

    public List<Question> getQuestionsBySession(Long sessionId) {
        return questionRepository.findAll()
                .stream()
                .filter(q -> q.getSessionId().equals(sessionId))
                .toList();
    }
}