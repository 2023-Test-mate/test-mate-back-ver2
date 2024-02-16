package com.testmateback.dTestmate.subject.dto;

import com.testmateback.dTestmate.subject.entity.Exam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDetailsDTO {
    private Long subjectId;
    private List<Exam> exams;
    private LocalDate date;
    private int level;
    private int goalScore;
    private int fail;
}
