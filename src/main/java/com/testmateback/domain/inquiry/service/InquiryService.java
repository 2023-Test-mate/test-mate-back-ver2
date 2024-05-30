package com.testmateback.domain.inquiry.service;

import com.testmateback.domain.inquiry.dto.CreateInquiryReq;
import com.testmateback.domain.inquiry.entity.Inquiry;
import com.testmateback.domain.inquiry.respository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InquiryService {
    private final InquiryRepository inquiryRepository;

    public Inquiry createInquiry(CreateInquiryReq CreateInquiryReq) {
        Inquiry inquiry = new Inquiry();
        inquiry.setContent(CreateInquiryReq.getContent());
        inquiry.setTitle(CreateInquiryReq.getTitle());
        inquiry.setImgs(CreateInquiryReq.getImgs());
        return inquiryRepository.save(inquiry);
    }

    public Inquiry findInquiryById(Long id) {
        return inquiryRepository.findByInquiryId(id);
    }

    public List<Inquiry> findAll() {
        return inquiryRepository.findAll();
    }
}
