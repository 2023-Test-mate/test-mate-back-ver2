package com.testmateback.domain.goal.repository;

import com.testmateback.domain.goal.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findBySubjectIdAndSemester(int subjectId, int semester);

    @Query("SELECT g.semester FROM Goal g WHERE g.subjectId = :subjectId ORDER BY g.lastModifiedDate DESC")
    Optional<Integer> findRecentSemesterBySubjectId(@Param("subjectId") int subjectId);


}