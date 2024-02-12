package com.testmateback.dTestmate.wrongnote.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWrongNoteReq {

    private int subjectId;
    private int grade;
    private String title;

    private String problemText;
    private String problemImg;

    private String solution;
    private String styles;
    private String reason;
    private String range;
}
