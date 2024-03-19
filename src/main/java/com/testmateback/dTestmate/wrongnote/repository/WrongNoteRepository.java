package com.testmateback.dTestmate.wrongnote.repository;

import com.testmateback.dTestmate.wrongnote.entity.WrongNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WrongNoteRepository extends JpaRepository<WrongNote, Long> {

    List<WrongNote> findBySubjectIdAndGrade(int subjectId, int grade);
    List<WrongNote> findBySubjectId(int subjectId);

//    @Query(("SELECT wn.reason, COUNT(wn.reason) * 100.0/(SELECT COUNT(*) FROM WrongNote wn2 WHERE wn2.subjectId = :subjectId) AS percentage FROM WrongNote wn WHERE wn.subjectId = :subjectId GROUP BY wn.reason"))
//    List<Object[]> findReasonsWithPercentageBySubjectId(int subjectId);

    @Query(("SELECT wn.reason, COUNT(wn.reason) * 100.0 / (SELECT COUNT(*) FROM WrongNote wn2 WHERE wn2.subjectId = :subjectId) AS percentage FROM WrongNote wn WHERE wn.subjectId = :subjectId GROUP BY wn.reason ORDER BY percentage DESC"))
    List<Object[]> findReasonsWithPercentageBySubjectId(int subjectId);

}