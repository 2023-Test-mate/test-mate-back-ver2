package com.testmateback.domain.subject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSubjectReq {
    private String subjectName;
    private MultipartFile img;
}
