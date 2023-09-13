
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
                .subject(request.getSubject())
                .semester(request.getSemester())
                .photo(request.getPhoto())
                .solution(request.getSolution())
                .styles(request.getStyles())
                .reason(request.getReason())
                .scopes(request.getScopes())
                .reasoncheck(request.getReasoncheck())
                .scopecheck(request.getScopecheck())
                .build();

        wrongNoteRepository.save(wrongNote);

        return CreateWrongNote.Response.WrongNoteResponse(wrongNote);
    }
}