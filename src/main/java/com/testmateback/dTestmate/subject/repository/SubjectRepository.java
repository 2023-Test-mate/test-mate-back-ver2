package com.testmateback.dTestmate.subject.repository;

import com.testmateback.dTestmate.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    List<Subject> findByUserIdAndGrade(Long userId, int grade);
}
