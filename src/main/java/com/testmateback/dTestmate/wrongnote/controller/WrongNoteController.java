package com.testmateback.dTestmate.wrongnote.controller;

import com.testmateback.dTestmate.wrongnote.dao.WrongNoteFilter;
import com.testmateback.dTestmate.wrongnote.dto.CreateWrongNoteReq;
import com.testmateback.dTestmate.wrongnote.entity.WrongNote;
import com.testmateback.dTestmate.wrongnote.service.WrongNoteService;
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
    public WrongNote addWrongNote(@RequestBody CreateWrongNoteReq createWrongNoteReq) {
        return wrongNoteService.createWrongNote(createWrongNoteReq);
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
    public ResponseEntity<WrongNote> updateWrongNote(@PathVariable Long noteId, @RequestBody WrongNote updatedWrongNote) {
        WrongNote result = wrongNoteService.updateWrongNote(noteId, updatedWrongNote);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity<Void> deleteWrongNote(@PathVariable Long noteId) {
        wrongNoteService.deleteWrongNote(noteId);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/top3ranges/{subjectId}")
    public List<String> getTop3RangesBySubjectId(@PathVariable int subjectId) {
        return wrongNoteService.findTop3RangesBySubjectId(subjectId);
    }
}

