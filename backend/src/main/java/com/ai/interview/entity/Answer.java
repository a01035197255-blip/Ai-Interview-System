package com.ai.interview.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long questionId; // 어떤 질문인지

    private String answerText; // 답변 내용

    private Integer score; // 답변 점수 (나중에 AI or 로직)

    private String feedback; // 피드백
}