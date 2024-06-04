package com.testmateback.domain.goal.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GoalSubjectsDTO {
    private Long subjectId;
    private String subjectName;
    private String img;
    private int recentSemester;
}
