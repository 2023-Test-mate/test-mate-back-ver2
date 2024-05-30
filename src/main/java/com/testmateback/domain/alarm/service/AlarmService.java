package com.testmateback.domain.alarm.service;

import com.testmateback.domain.alarm.dao.AlarmStatusResponse;
import com.testmateback.domain.alarm.entity.Alarm;
import com.testmateback.domain.alarm.repository.AlarmRepository;
import com.testmateback.domain.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class AlarmService{

    private final AlarmRepository alarmRepository;
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

    public AlarmStatusResponse getAlarmStatusByUserId() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        AlarmStatusResponse response = new AlarmStatusResponse();
        Alarm entity = alarmRepository.findByUserId(userId);
        response.setStatus(entity.isCompleted());
        return response;
    }



    public void updateCompletedValue() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        Alarm entity = alarmRepository.findByUserId(userId);
        if (entity != null) {
            entity.setCompleted(!entity.isCompleted());
            alarmRepository.save(entity);
        } else {
            throw new RuntimeException("alarm don't change");
        }
    }


}
