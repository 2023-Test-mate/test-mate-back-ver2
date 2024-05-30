package com.testmateback.domain.wrongnote.dto;

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

    private String imgs;
    private String styles;
    private String reason;
    private String range;
}
