package com.testmateback.dTestmate.wrongnote.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WrongNoteFilter {
    private Long noteId;
    private int subjectId;
    private int grade;
    private String title;
    private String problemText;
    private String problemImg;
    private String reason;
}
