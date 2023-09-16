package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.WrongNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrongNoteRepository extends JpaRepository<WrongNote, Long> {

    List<WrongNote> findByIndexesAndGradeAndSubject(String indexes, String grade, String subject);
}