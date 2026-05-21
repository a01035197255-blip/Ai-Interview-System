package com.ai.interview.service;

import com.ai.interview.dto.SessionRequest;
import com.ai.interview.entity.InterviewSession;
import com.ai.interview.repository.InterviewSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final InterviewSessionRepository sessionRepository;

    public SessionService(InterviewSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    // 면접 시작 (DTO 반영)
    public InterviewSession startSession(SessionRequest request) {

        InterviewSession session = new InterviewSession();
        session.setStatus("READY");
        session.setScore(0);

        // 나중 확장용 (직무/난이도)
        // session.setJobType(request.getJobType());
        // session.setLevel(request.getLevel());

        return sessionRepository.save(session);
    }

    // 전체 session 조회
    public List<InterviewSession> getAllSessions() {
        return sessionRepository.findAll();
    }

    // 단일 session 조회
    public InterviewSession getSession(Long id) {
        return sessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Session not found"));
    }
}