package com.ai.interview.controller;

import com.ai.interview.dto.SessionRequest;
import com.ai.interview.dto.SessionResponse;
import com.ai.interview.entity.InterviewSession;
import com.ai.interview.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // 면접 시작 (DTO 입력)
    @PostMapping("/start")
    public InterviewSession startSession(@RequestBody SessionRequest request) {
        return sessionService.startSession(request);
    }

    // 전체 session 조회 (DTO 출력)
    @GetMapping("/list")
    public List<SessionResponse> getAllSessions() {
        return sessionService.getAllSessions()
                .stream()
                .map(s -> new SessionResponse(
                        s.getId(),
                        s.getStatus(),
                        s.getScore(),
                        s.getCreatedAt()
                ))
                .toList();
    }

    // session 1개 조회
    @GetMapping("/{id}")
    public InterviewSession getSession(@PathVariable Long id) {
        return sessionService.getSession(id);
    }
}