package com.testmateback.domain.inquiry.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInquiryReq {

    private String content;

    private String imgs;

    private String title;

}
