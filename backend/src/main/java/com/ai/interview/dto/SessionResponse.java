package com.ai.interview.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class SessionResponse {

    private Long id;
    private String status;
    private Integer score;
    private LocalDateTime createdAt;
}