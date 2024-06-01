package com.testmateback.domain.wrongnote.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateWrongNoteReq {

    private int subjectId;
    private int grade;
    private String title;

    private List<MultipartFile> imgs;
    private String styles;
    private String reason;
    private String range;
}
