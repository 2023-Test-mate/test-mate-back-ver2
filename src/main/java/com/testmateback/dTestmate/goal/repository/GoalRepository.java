package com.testmateback.dTestmate.goal.repository;

import com.testmateback.dTestmate.goal.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    long countByChecksIsTrue(); // 메서드 이름 변경
    List<Goal> findAll();

    long countBySubject(String subject);

    List<Goal> findBySubject(String subject);

    List<Goal> findBySubjectAndChecksTrue(String subject);

    List<Goal> findByIndexesAndSubjectAndGradeAndChecks(String indexes, String subject, String grade, boolean b);

    void deleteByIndexesAndSubjectAndGrade(String indexes, String subject, String grade);

    void deleteByIndexesAndSubjectAndGradeAndGoal(String indexes, String subject, String grade, String goal);
}