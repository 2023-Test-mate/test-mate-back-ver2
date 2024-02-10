package com.testmateback.dTestmate.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamScoreReq {
    private String examName;
    private int examScore;
}
