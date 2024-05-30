package com.testmateback.domain.wrongnote.service;

import com.testmateback.domain.util.SessionUtil;
import com.testmateback.domain.wrongnote.dto.CreateRangeReq;
import com.testmateback.domain.wrongnote.entity.Range;
import com.testmateback.domain.wrongnote.repository.RangeRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RangeService {

    private final RangeRepository rangeRepository;
    private final HttpSession session;

    @Autowired
    public RangeService(RangeRepository rangeRepository, HttpSession session) {
        this.rangeRepository = rangeRepository;
        this.session = session;
    }

    // 범위 추가
    public Range createRange(CreateRangeReq createRangeReq) {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        Range range = new Range();
        range.setUserId(userId);
        range.setRange(createRangeReq.getRange());
        return rangeRepository.save(range);
    }

    // 범위 가져오기
    public List<Range> getRangesByUserId() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        return rangeRepository.findByUserId(userId);
    }


    // 범위 수정
    public Range updateRange(int rangeId, Range updatedRange) {
        Range existingRange = rangeRepository.findById(rangeId).orElse(null);
        if (existingRange != null) {
            existingRange.setRange(updatedRange.getRange());
            return rangeRepository.save(existingRange);
        } else {
            return null;
        }
    }

    // 범위 삭제
    public void deleteRange(int rangeId) {
        rangeRepository.deleteById(rangeId);
    }
}