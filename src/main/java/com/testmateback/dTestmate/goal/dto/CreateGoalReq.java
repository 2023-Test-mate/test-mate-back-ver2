package com.testmateback.dTestmate.goal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateGoalReq {
    private int subjectId;
    private int semester;
    private String goal;
    private boolean completed;
}
