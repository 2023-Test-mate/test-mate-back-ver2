package com.testmateback.dTestmate.controller;

import com.testmateback.dTestmate.dto.CreateWrongNote;
import com.testmateback.dTestmate.entity.WrongNote;
import com.testmateback.dTestmate.entity.WrongNoteDetails;
import com.testmateback.dTestmate.repository.WrongNoteRepository;
import com.testmateback.dTestmate.service.WrongNoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class WrongNoteController {

    private final WrongNoteService wrongNoteService;

    public WrongNoteController(WrongNoteService wrongNoteService) {
        this.wrongNoteService = wrongNoteService;
    }

    // 오답 노트 정보 생성 요청 처리
    @PostMapping("/wrong-note")
    public CreateWrongNote.Response createWrongNote(
            @Valid @RequestBody CreateWrongNote.Request request
    ) {
        log.info("request : {} ", request);
        return wrongNoteService.createWrongNote(request);
    }

    // 오답 노트 관련 기능을 처리하는 컨트롤러 클래스
    @RestController
    @RequestMapping("/wrong-note")
    @RequiredArgsConstructor
    public class wrongController {
        @Autowired
        private WrongNoteRepository wrongNoteRepository;

        @GetMapping("/details")
        public WrongNoteDetails getWrongNoteDetails(@RequestParam String indexes, @RequestParam String subject, @RequestParam String grade) {
            WrongNoteDetails wrongNoteDetails = new WrongNoteDetails();
            wrongNoteDetails.setIndexes(indexes);

            WrongNote wrongNote = (WrongNote) wrongNoteRepository.findBySubjectAndGradeAndIndexes(indexes, grade, grade).orElse(null);

            if (wrongNote != null) {
                wrongNoteDetails.setWtitle(wrongNote.getTitle());
                wrongNoteDetails.setWreason(wrongNote.getReason());
                wrongNoteDetails.setWphoto(wrongNote.getPhoto());
                wrongNoteDetails.setWproblem(wrongNote.getProblem());
            }
            return wrongNoteDetails;
        }
    }
}
