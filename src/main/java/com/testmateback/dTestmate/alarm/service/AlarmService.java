package com.testmateback.dTestmate.alarm.service;

import com.testmateback.dTestmate.alarm.dto.AlarmDTO;
import com.testmateback.dTestmate.alarm.entity.Alarm;
import com.testmateback.dTestmate.alarm.repository.AlarmRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlarmService{

    private static AlarmRepository alarmRepository;
    private final HttpSession session;
    private final static String LOGIN_SESSION_KEY = "USER_ID";

    public AlarmService(AlarmRepository alarmRepository, HttpSession session) {
        this.alarmRepository = alarmRepository;
        this.session = session;
    }

    public Alarm addAlarm() {
        Long currentUserId = getCurrentUserIdFromSession();
        Alarm alarm = new Alarm();
        alarm.setUserId(currentUserId);
        alarm.setCompleted(true);
        return alarmRepository.save(alarm);
    }

    public boolean getAlarmStatusByUserId(Long userId) {
        Alarm entity = alarmRepository.findByUserId(userId);
        return (entity != null) ? entity.isCompleted() : false ;
    }

    public void updateCompletedValue(Long userId, AlarmDTO completed) {
        Alarm entity = alarmRepository.findByUserId(userId);
        if (entity != null) {
            entity.setCompleted(completed.isCompleted());
            alarmRepository.save(entity);
        } else {
            throw new RuntimeException("alarm don't change");
        }
    }


    private Long getCurrentUserIdFromSession() {
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);
        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }

}