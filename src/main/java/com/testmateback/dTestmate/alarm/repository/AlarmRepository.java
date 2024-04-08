package com.testmateback.dTestmate.alarm.repository;

import com.testmateback.dTestmate.alarm.entity.Alarm;
import com.testmateback.dTestmate.calendar.entity.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long>{
    Alarm findByUserId(Long userId);

    //Optional<Alarm> findByUserId(Long userId);

}
