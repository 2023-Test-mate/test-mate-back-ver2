package com.testmateback.dTestmate.wrongnote.service;

import com.testmateback.dTestmate.wrongnote.dto.CreateRangeReq;
import com.testmateback.dTestmate.wrongnote.entity.Range;
import com.testmateback.dTestmate.wrongnote.repository.RangeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RangeService {

    private final RangeRepository rangeRepository;
    private final HttpSession session;
    private final static String LOGIN_SESSION_KEY = "USER_ID";

    @Autowired
    public RangeService(RangeRepository rangeRepository, HttpSession session) {
        this.rangeRepository = rangeRepository;
        this.session = session;
    }

    // 범위 추가
    public Range createRange(CreateRangeReq createRangeReq) {
        Long userId = getCurrentUserIdFromSession();
        Range range = new Range();
        range.setUserId(userId);
        range.setRange(createRangeReq.getRange());
        return rangeRepository.save(range);
    }

    // 범위 가져오기
    public List<Range> getRangesByUserId() {
        Long userId = getCurrentUserIdFromSession();
        return rangeRepository.findByUserId(userId);
    }


    // 범위 수정
    public Range updateRange(int rangeId, Range updatedRange) {
        Range existingRange = rangeRepository.findById(rangeId).orElse(null);
        if (existingRange != null) {
            existingRange.setRange(updatedRange.getRange());
            return rangeRepository.save(existingRange);
        } else {
            return null; // or throw an exception, depending on your requirements
        }
    }

    // 범위 삭제
    public void deleteRange(int rangeId) {
        rangeRepository.deleteById(rangeId);
    }

    private Long getCurrentUserIdFromSession() {
        // 세션에서 사용자 ID를 가져오는 로직
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }
}