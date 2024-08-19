package com.testmateback.domain.goal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GoalSubjectsDTO {
    private Long subjectId;
    private String subjectName;
    private String img;
    private int recentSemester;
}
