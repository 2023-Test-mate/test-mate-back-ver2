
package com.testmateback.dTestmate.wrongnote.service;


import com.testmateback.dTestmate.wrongnote.dao.WrongNoteFilter;
import com.testmateback.dTestmate.wrongnote.dto.CreateWrongNoteReq;
import com.testmateback.dTestmate.wrongnote.entity.WrongNote;
import com.testmateback.dTestmate.wrongnote.repository.WrongNoteRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
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
        wrongNote.setStyles(createWrongNoteReq.getStyles());
        wrongNote.setImgs(createWrongNoteReq.getImgs());
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
                wrongNote.getImgs(),
                wrongNote.getReason()
        );
    }
    // 오답노트 수정
    public WrongNote updateWrongNote(Long noteId, WrongNote updatedWrongNote) {
        Optional<WrongNote> existingWrongNoteOptional = wrongNoteRepository.findById(noteId);

        if (existingWrongNoteOptional.isPresent()) {
            WrongNote existingWrongNote = existingWrongNoteOptional.get();
            existingWrongNote.setNoteId(updatedWrongNote.getNoteId());
            existingWrongNote.setSubjectId(updatedWrongNote.getSubjectId());
            existingWrongNote.setGrade(updatedWrongNote.getGrade());
            existingWrongNote.setTitle(updatedWrongNote.getTitle());
            existingWrongNote.setStyles(updatedWrongNote.getStyles());
            existingWrongNote.setImgs(updatedWrongNote.getImgs());
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

    // 홈 - 문제 범위 top3
    public List<String> findTop3RangesBySubjectId(int subjectId) {
        List<WrongNote> subjectWrongNotes = wrongNoteRepository.findBySubjectId(subjectId);

        // subjectId에 속하는 모든 range 데이터 수집
        List<String> allRanges = subjectWrongNotes.stream()
                .map(WrongNote::getRange)
                .collect(Collectors.toList());

        // 각 range의 등장 횟수를 세기
        Map<String, Long> rangeCount = allRanges.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // 등장 횟수를 기준으로 내림차순 정렬
        List<String> sortedRanges = rangeCount.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // 상위 3개의 range 추출
        return sortedRanges.subList(0, Math.min(3, sortedRanges.size()));
    }

    // 홈 - 오답실수 top 3
    public List<Object[]> findReasonsWithPercentageBySubjectId(int subjectId) {
        List<Object[]> allReasonsWithPercentage = wrongNoteRepository.findReasonsWithPercentageBySubjectId(subjectId);
        List<Object[]> topThreeReasons = new ArrayList<>();
        int count = 0;
        for (Object[] reasonWithPercentage : allReasonsWithPercentage) {
            if (count < 3) {
                topThreeReasons.add(reasonWithPercentage);
                count++;
            } else {
                break;
            }
        }
        return topThreeReasons;
    }

}