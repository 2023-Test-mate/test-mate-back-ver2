package com.testmateback.domain.wrongnote.service;

import com.testmateback.domain.wrongnote.dto.CreateReasonReq;
import com.testmateback.domain.wrongnote.entity.Reason;
import com.testmateback.domain.wrongnote.repository.ReasonRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReasonService {

    private final ReasonRepository reasonRepository;
    private final HttpSession session;
    private final static String LOGIN_SESSION_KEY = "USER_ID";

    public ReasonService(ReasonRepository reasonRepository, HttpSession session) {
        this.reasonRepository = reasonRepository;
        this.session = session;
    }

    // 오답 이유 추가
    public Reason createRange(CreateReasonReq createReasonReq) {
        Long userId = getCurrentUseridFromSession();
        Reason reason = new Reason();
        reason.setUserId(userId);
        reason.setReason(createReasonReq.getReason());
        return reasonRepository.save(reason);
    }

    // 오답 이유 가져오기
    public List<Reason> getReasonsByUserId() {
        Long userId = getCurrentUseridFromSession();
        return reasonRepository.findByUserId(userId);
    }

    // 오답 이유 수정
    public Reason updateReason(int reasonId, Reason updateReason) {
        Reason existingReason = reasonRepository.findById(reasonId).orElse(null);
        if(existingReason != null) {
            existingReason.setReason(updateReason.getReason());
            return reasonRepository.save(existingReason);
        } else {
            return null;
        }
    }

    // 오답 이유 삭제
    public void deleteReason(int reasonId) {
        reasonRepository.deleteById(reasonId);
    }

    private Long getCurrentUseridFromSession() {
        // 세션에서 사용자 ID를 가져오는 로직
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if(userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }
}
