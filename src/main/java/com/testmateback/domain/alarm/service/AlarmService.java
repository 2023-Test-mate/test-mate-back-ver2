package com.testmateback.domain.alarm.service;

import com.testmateback.domain.alarm.entity.Alarm;
import com.testmateback.domain.alarm.repository.AlarmRepository;
import com.testmateback.domain.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AlarmService{

    private static AlarmRepository alarmRepository;
    private final HttpSession session;

    public AlarmService(AlarmRepository alarmRepository, HttpSession session) {
        this.alarmRepository = alarmRepository;
        this.session = session;
    }

    public Alarm addAlarm() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        Alarm alarm = new Alarm();
        alarm.setUserId(userId);
        alarm.setCompleted(true);
        return alarmRepository.save(alarm);
    }

    public boolean getAlarmStatusByUserId(Long userId) {
        Alarm entity = alarmRepository.findByUserId(userId);
        return (entity != null) ? entity.isCompleted() : false ;
    }

    public void updateCompletedValue(Long userId) {
        Alarm entity = alarmRepository.findByUserId(userId);
        if (entity != null) {
            entity.setCompleted(!entity.isCompleted());
            alarmRepository.save(entity);
        } else {
            throw new RuntimeException("alarm don't change");
        }
    }


}
