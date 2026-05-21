package com.ai.interview.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerRequest {

    private Long questionId;
    private String answerText;
}