package com.testmateback.dTestmate.goal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGoalReq {
    private int subjectId;
    private int grade;
    private List<GoalDTO> goals;
}
