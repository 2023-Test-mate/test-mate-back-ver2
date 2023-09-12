
package com.testmateback.dTestmate.service;


import com.testmateback.dTestmate.dto.CreateWrongNote;
import com.testmateback.dTestmate.entity.WrongNote;
import com.testmateback.dTestmate.repository.WrongNoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WrongNoteService {
    private final WrongNoteRepository wrongNoteRepository;

    public WrongNoteService(WrongNoteRepository wrongNoteRepository) {
        this.wrongNoteRepository = wrongNoteRepository;
    }

    @Transactional
    public CreateWrongNote.Response createWrongNote(CreateWrongNote.Request request){
        WrongNote wrongNote = WrongNote.builder()
                .indexes(request.getIndexes())
                .note_subject(request.getNote_subject())
                .note_semester(request.getNote_semester())
                .note_photo(request.getNote_photo())
                .note_solution(request.getNote_solution())
                .note_testStyle(request.getNote_testStyle())
                .note_reason(request.getNote_reason())
                .note_testScope(request.getNote_testScope())
                .build();

        wrongNoteRepository.save(wrongNote);

        return CreateWrongNote.Response.WrongNoteResponse(wrongNote);
    }
}