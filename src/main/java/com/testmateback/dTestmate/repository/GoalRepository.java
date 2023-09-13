package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
    long countByChecksIsTrue(); // 메서드 이름 변경
}