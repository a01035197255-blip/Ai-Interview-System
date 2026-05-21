package com.ai.interview.service;

import com.ai.interview.entity.Answer;
import com.ai.interview.repository.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer saveAnswer(Long questionId, String answerText) {

        Answer answer = new Answer();
        answer.setQuestionId(questionId);
        answer.setAnswerText(answerText);

        int score = calculateScore(answerText);
        answer.setScore(score);
        answer.setFeedback(generateFeedback(score));

        return answerRepository.save(answer);
    }

    public List<Answer> getAnswers() {
        return answerRepository.findAll();
    }

    private int calculateScore(String text) {
        if (text == null || text.length() < 20) return 30;
        if (text.length() < 50) return 60;
        return 90;
    }

    private String generateFeedback(int score) {
        if (score < 50) return "답변이 너무 짧습니다.";
        if (score < 80) return "좋지만 예시 추가 필요";
        return "좋은 답변입니다!";
    }
}