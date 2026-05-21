package com.ai.interview.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 면접 시작 요청 DTO
 * (프론트 → 백엔드)
 */
@Getter
@Setter
public class SessionRequest {

    // 나중에 확장용 (예: 직무, 난이도)
    private String jobType;   // 예: "backend", "frontend"
    private String level;     // 예: "junior", "senior"
}