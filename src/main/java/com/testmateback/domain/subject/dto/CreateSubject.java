package com.testmateback.domain.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubject {
    private int userId;
    private int grade;
    private String subjectName;
    private String img;

}
