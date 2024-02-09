package com.testmateback.dTestmate.subject;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class EditSubjectController {

    private final EditSubjectService editSubjectService;

    public EditSubjectController(EditSubjectService editSubjectService) {
        this.editSubjectService = editSubjectService;
    }

    // 과목 정보 생성 요청 처리
    @PostMapping("/edit-subject")
    public CreateEditSubject.Response createEditSubject(
            @Valid @RequestBody CreateEditSubject.Request request
    ) {
        log.info("request : {}", request);
        return editSubjectService.createEditSubject(request);
    }

}
