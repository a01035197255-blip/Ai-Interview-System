package com.ai.interview.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class InterviewSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status; // READY, ONGOING, DONE

    private Integer score; // 전체 점수 (나중에)

    private LocalDateTime createdAt = LocalDateTime.now();
}