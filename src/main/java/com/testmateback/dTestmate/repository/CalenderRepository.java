package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalenderRepository extends JpaRepository<Calendar, Long> {

    List<Calendar> findByIndexes(String indexes);

    Calendar deleteByIndexesAndSubjectAndDate(String indexes, String subject, String date);
}