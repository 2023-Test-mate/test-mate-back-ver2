package com.testmateback.dTestmate.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubjectReq {
    private String subjectName;
    private String img;
}
