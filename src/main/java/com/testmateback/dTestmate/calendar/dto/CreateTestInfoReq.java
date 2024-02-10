package com.testmateback.dTestmate.calendar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTestInfoReq {
    private LocalDate date;
    private String subject;
}
