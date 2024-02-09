package com.testmateback.dTestmate.wrongnote;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WrongNoteDetails {
    private String indexes;
    private String wSubjects;
    private String wtitle;
    private String wreason;
    private byte[] wphoto;
    private String wproblem;
    String getIndexes() {
        return indexes;
    }

}