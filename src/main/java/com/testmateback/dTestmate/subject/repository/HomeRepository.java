package com.testmateback.dTestmate.subject.repository;

import com.testmateback.dTestmate.subject.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {
    List<Home> findByIndexesAndGradeAndSubject(String indexes, String grade, String subject);
}