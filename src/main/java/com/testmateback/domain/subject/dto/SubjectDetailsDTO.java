package com.testmateback.domain.subject.dto;

import com.testmateback.domain.subject.entity.Exam;
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
