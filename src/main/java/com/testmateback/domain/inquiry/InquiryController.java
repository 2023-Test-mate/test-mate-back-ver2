package com.testmateback.domain.inquiry;

import com.testmateback.domain.inquiry.dto.CreateInquiryReq;
import com.testmateback.domain.inquiry.entity.Inquiry;
import com.testmateback.domain.inquiry.service.InquiryService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/inquiry")
public class InquiryController {

    private final InquiryService inquiryService;

    @PostMapping
    public ResponseEntity<ResponseMessage> createInquiry(@RequestBody CreateInquiryReq req) {
        Inquiry inquiry = inquiryService.createInquiry(req);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
    }

    @GetMapping
    public ResponseEntity<List<Inquiry>> getAllInquiry() {
        return ResponseEntity.ok(inquiryService.findAll());
    }

    @GetMapping("/{inquiry_id}")
    public ResponseEntity<Inquiry> getInquiryById(@PathVariable("inquiry_id") Long id) {
        Inquiry inquiry = inquiryService.findInquiryById(id);

        return ResponseEntity.ok(inquiry);
    }

}
