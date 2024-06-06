package com.testmateback.domain.calendar.repository;

import com.testmateback.domain.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {

    List<Calendar> findByUserId(Long userId);

    List<Calendar> findByUserIdAndDate(Long userId, LocalDate date);

    List<Calendar> findCalendarByUserIdAndDate(Long userId, LocalDate date);

    List<Calendar> findCalendarByUserIdAndDateBetween(Long userId, LocalDate startDate, LocalDate endDate);
}