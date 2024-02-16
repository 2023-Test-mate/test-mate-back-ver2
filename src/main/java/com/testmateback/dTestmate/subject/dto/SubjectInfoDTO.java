package com.testmateback.dTestmate.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SubjectInfoDTO {
    private Long subjectId;
    private String subjectName;
    private String img;
}
