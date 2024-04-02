package com.testmateback.dTestmate.alarm.repository;

import com.testmateback.dTestmate.alarm.entity.Alarm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlarmRepository extends JpaRepository<Alarm, Long>{

}
