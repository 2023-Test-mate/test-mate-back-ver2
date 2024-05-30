package com.testmateback.domain.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTestRecordReq {
    private List<ExamScoreReq> exams;
    private LocalDate date;
    private int goalScore;
    private int level;
    private String comment;

}
