package com.testmateback.dTestmate.inquiry;

import com.testmateback.dTestmate.inquiry.dto.CreateInquiryReq;
import com.testmateback.dTestmate.inquiry.entity.Inquiry;
import com.testmateback.dTestmate.inquiry.service.InquiryService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/inquiry")
public class InquiryController {

    private final InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<Inquiry> createInquiry(@RequestBody CreateInquiryReq req) {
        Inquiry inquiry = inquiryService.createInquiry(req);
        return ResponseEntity.ok(inquiry);
    }

    @GetMapping
    public ResponseEntity<List<Inquiry>> getAllInquiry() {
        return ResponseEntity.ok(inquiryService.findAll());
    }

}
