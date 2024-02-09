package com.testmateback.dTestmate.subject;

import com.testmateback.dTestmate.subject.repository.EditSubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditSubjectService {
    private final EditSubjectRepository editSubjectRepository;

    public EditSubjectService(EditSubjectRepository editSubjectRepository) {
        this.editSubjectRepository = editSubjectRepository;
    }


    @Transactional
    public CreateEditSubject.Response createEditSubject(CreateEditSubject.Request request){
        EditSubject editSubject = EditSubject.builder()
                .indexes(request.getIndexes())
                .subject(request.getSubject())
                .photo(request.getPhoto())
                .grade(request.getGrade())
                .build();

        editSubjectRepository.save(editSubject);

        return CreateEditSubject.Response.EditSubjectResponse(editSubject);
    }
}