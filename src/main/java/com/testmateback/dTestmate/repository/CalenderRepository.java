package com.testmateback.dTestmate.repository;

import com.testmateback.dTestmate.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalenderRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findAll();
}