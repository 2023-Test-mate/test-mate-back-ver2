package com.testmateback.domain.wrongnote;

import com.testmateback.domain.wrongnote.entity.Range;
import com.testmateback.domain.wrongnote.entity.Reason;
import com.testmateback.domain.wrongnote.repository.RangeRepository;
import com.testmateback.domain.wrongnote.repository.ReasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DataLoader {

    private final ReasonRepository reasonRepository;
    private final RangeRepository rangeRepository;

    @Autowired
    public DataLoader(ReasonRepository reasonRepository, RangeRepository rangeRepository) {
        this.reasonRepository = reasonRepository;
        this.rangeRepository = rangeRepository;
    }



    private void createRange(String rangeValue, Long userId) {
        Range range = new Range();
        range.setUserId(userId);
        range.setRange(rangeValue);
        rangeRepository.save(range);
    }
    private void createReason(String reasonValue, Long userId) {
        Reason reason = new Reason();
        reason.setUserId(userId);
        reason.setReason(reasonValue);
        reasonRepository.save(reason);
    }


    @Transactional
    public void DataInit(long userId) {
        createReason("실수", userId);
        createReason("시간 부족", userId);
        createReason("개념 부족", userId);
        createRange("자료", userId);
        createRange("교교서", userId);
        createRange("참고서", userId);
        createRange("문제집", userId);
    }
}
