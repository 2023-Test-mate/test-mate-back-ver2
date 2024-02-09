package com.testmateback.dTestmate.wrongnote.repository;

import com.testmateback.dTestmate.wrongnote.WrongNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WrongNoteRepository extends JpaRepository<WrongNote, Long> {

    List<WrongNote> findByIndexesAndGradeAndSubject(String indexes, String grade, String subject);

    Optional<Object> findBySubjectAndGradeAndIndexes(String subject, String grade, String indexes);

}