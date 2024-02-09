package com.testmateback.dTestmate.subject.repository;

import com.testmateback.dTestmate.subject.EditSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditSubjectRepository extends JpaRepository<EditSubject, Long> {
    EditSubject findBySubject(String indexes);

    List<EditSubject> findByIndexesAndSubjectAndGrade(String indexes, String  subject, String grade);
}