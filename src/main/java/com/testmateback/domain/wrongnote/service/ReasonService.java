package com.testmateback.domain.wrongnote.service;

import com.testmateback.domain.util.SessionUtil;
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

    public ReasonService(ReasonRepository reasonRepository, HttpSession session) {
        this.reasonRepository = reasonRepository;
        this.session = session;
    }

    // 오답 이유 추가
    public Reason createRange(CreateReasonReq createReasonReq) {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        Reason reason = new Reason();
        reason.setUserId(userId);
        reason.setReason(createReasonReq.getReason());
        return reasonRepository.save(reason);
    }

    // 오답 이유 가져오기
    public List<Reason> getReasonsByUserId() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
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

}
