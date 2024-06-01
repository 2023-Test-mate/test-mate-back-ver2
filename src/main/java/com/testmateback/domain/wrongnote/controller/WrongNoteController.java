package com.testmateback.domain.wrongnote.controller;

import com.testmateback.domain.wrongnote.dao.WrongNoteFilter;
import com.testmateback.domain.wrongnote.dto.CreateWrongNoteReq;
import com.testmateback.domain.wrongnote.entity.WrongNote;
import com.testmateback.domain.wrongnote.service.WrongNoteService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/note")
public class WrongNoteController {

    @Autowired
    private WrongNoteService wrongNoteService;

    @PostMapping
    public ResponseEntity<ResponseMessage> addWrongNote(@ModelAttribute CreateWrongNoteReq createWrongNoteReq) {
        wrongNoteService.createWrongNote(createWrongNoteReq);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
    }

    @GetMapping
    public List<WrongNote> getAllWrongNotes() {
        return wrongNoteService.getAllWrongNotes();
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<WrongNote> getWrongNoteById(@PathVariable Long noteId) {
        Optional<WrongNote> wrongNoteOptional = wrongNoteService.getWrongNoteById(noteId);
        return wrongNoteOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public List<WrongNoteFilter> getFilteredWrongNotes(@RequestParam(required = false) Integer subjectId,
                                                       @RequestParam(required = false) Integer grade) {
        return wrongNoteService.getFilteredWrongNotes(subjectId, grade);
    }


    @PutMapping("/{noteId}")
    public ResponseEntity<ResponseMessage> updateWrongNote(@PathVariable Long noteId, @RequestBody WrongNote updatedWrongNote) {
        wrongNoteService.updateWrongNote(noteId, updatedWrongNote);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));

    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<ResponseMessage> deleteWrongNote(@PathVariable Long noteId) {
        wrongNoteService.deleteWrongNote(noteId);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_DELETE.getMessage()));

    }
    @GetMapping("/top3ranges/{subjectId}")
    public List<String> getTop3RangesBySubjectId(@PathVariable int subjectId) {
        return wrongNoteService.findTop3RangesBySubjectId(subjectId);
    }

    @GetMapping("/top3reasons/{subjectId}")
    public List<Object[]> findReasonsWithPercentageBySubjectId(@PathVariable int subjectId) {
        return wrongNoteService.findReasonsWithPercentageBySubjectId(subjectId);
    }
}

