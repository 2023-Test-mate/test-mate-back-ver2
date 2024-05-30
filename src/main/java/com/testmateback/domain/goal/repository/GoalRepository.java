package com.testmateback.domain.goal.repository;

import com.testmateback.domain.goal.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findBySubjectIdAndSemester(int subjectId, int semester);
}