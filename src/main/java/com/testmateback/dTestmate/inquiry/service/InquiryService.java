package com.testmateback.dTestmate.inquiry.service;

import com.testmateback.dTestmate.inquiry.dto.CreateInquiryReq;
import com.testmateback.dTestmate.inquiry.entity.Inquiry;
import com.testmateback.dTestmate.inquiry.respository.InquiryRepository;
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

    public List<Inquiry> findAll() {
        return inquiryRepository.findAll();
    }
}
