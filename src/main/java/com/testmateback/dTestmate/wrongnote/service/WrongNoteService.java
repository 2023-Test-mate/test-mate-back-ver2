
package com.testmateback.dTestmate.wrongnote.service;


import com.testmateback.dTestmate.wrongnote.dao.WrongNoteFilter;
import com.testmateback.dTestmate.wrongnote.dto.CreateWrongNoteReq;
import com.testmateback.dTestmate.wrongnote.entity.WrongNote;
import com.testmateback.dTestmate.wrongnote.repository.WrongNoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WrongNoteService {

    private final WrongNoteRepository wrongNoteRepository;

    public WrongNoteService(WrongNoteRepository wrongNoteRepository) {
        this.wrongNoteRepository = wrongNoteRepository;
    }

    // 오답 노트 생성
    public WrongNote createWrongNote(CreateWrongNoteReq createWrongNoteReq) {
        WrongNote wrongNote = new WrongNote();
        wrongNote.setSubjectId(createWrongNoteReq.getSubjectId());
        wrongNote.setGrade(createWrongNoteReq.getGrade());
        wrongNote.setTitle(createWrongNoteReq.getTitle());
        wrongNote.setProblemImg(createWrongNoteReq.getProblemImg());
        wrongNote.setProblemText(createWrongNoteReq.getProblemText());
        wrongNote.setSolution(createWrongNoteReq.getSolution());
        wrongNote.setStyles(createWrongNoteReq.getStyles());
        wrongNote.setReason(createWrongNoteReq.getReason());
        wrongNote.setRange(createWrongNoteReq.getRange());

        return wrongNoteRepository.save(wrongNote);
    }

    // 오답 노트 모든 목록 불러오기
    public List<WrongNote> getAllWrongNotes() {
        return wrongNoteRepository.findAll();
    }

    // 오답노트 목록 불러오기
    public Optional<WrongNote> getWrongNoteById(Long noteId) {
        return wrongNoteRepository.findById(noteId);
    }

    // 오답노트 태그별로 불러오기
    public List<WrongNoteFilter> getFilteredWrongNotes(Integer subjectId, Integer grade) {
        // subjectId와 grade를 사용하여 필터된 WrongNote 목록을 가져옵니다.
        List<WrongNote> wrongNotes = wrongNoteRepository.findBySubjectIdAndGrade(subjectId, grade);

        return wrongNotes.stream()
                .map(this::convertToWrongNoteFilter)
                .collect(Collectors.toList());
    }

    private WrongNoteFilter convertToWrongNoteFilter(WrongNote wrongNote) {
        return new WrongNoteFilter(
                wrongNote.getNoteId(),
                wrongNote.getSubjectId(),
                wrongNote.getGrade(),
                wrongNote.getTitle(),
                wrongNote.getProblemText(),
                wrongNote.getProblemImg(),
                wrongNote.getReason()
        );
    }
    // 오답노트 수정
    public WrongNote updateWrongNote(Long noteId, WrongNote updatedWrongNote) {
        Optional<WrongNote> existingWrongNoteOptional = wrongNoteRepository.findById(noteId);

        if (existingWrongNoteOptional.isPresent()) {
            WrongNote existingWrongNote = existingWrongNoteOptional.get();
            existingWrongNote.setSubjectId(updatedWrongNote.getSubjectId());
            existingWrongNote.setGrade(updatedWrongNote.getGrade());
            existingWrongNote.setTitle(updatedWrongNote.getTitle());
            existingWrongNote.setProblemText(updatedWrongNote.getProblemText());
            existingWrongNote.setProblemImg(updatedWrongNote.getProblemImg());
            existingWrongNote.setSolution(updatedWrongNote.getSolution());
            existingWrongNote.setStyles(updatedWrongNote.getStyles());
            existingWrongNote.setReason(updatedWrongNote.getReason());
            existingWrongNote.setRange(updatedWrongNote.getRange());

            return wrongNoteRepository.save(existingWrongNote);
        } else {
            throw new EntityNotFoundException("해당 ID의 WrongNote를 찾을 수 없습니다: " + noteId);
        }
    }

    // 오답 노트 삭제
    public void deleteWrongNote(Long noteId) {
        if (wrongNoteRepository.existsById(noteId)) {
            wrongNoteRepository.deleteById(noteId);
        } else {
            throw new EntityNotFoundException("해당 ID의 WrongNote를 찾을 수 없습니다: " + noteId);
        }
    }
}