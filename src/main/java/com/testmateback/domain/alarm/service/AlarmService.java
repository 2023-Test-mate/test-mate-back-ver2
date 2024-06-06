package com.testmateback.domain.alarm.service;

import com.testmateback.domain.alarm.dto.AlarmStatusResponse;
import com.testmateback.domain.alarm.dto.NewAlarmResponse;
import com.testmateback.domain.alarm.dto.RecentAlarmResponse;
import com.testmateback.domain.alarm.entity.Alarm;
import com.testmateback.domain.alarm.repository.AlarmRepository;
import com.testmateback.domain.calendar.entity.Calendar;
import com.testmateback.domain.calendar.repository.CalendarRepository;
import com.testmateback.domain.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlarmService {

    private final AlarmRepository alarmRepository;
    private final CalendarRepository calendarRepository;
    private final HttpSession session;

    public AlarmService(AlarmRepository alarmRepository, CalendarRepository calendarRepository, HttpSession session) {
        this.alarmRepository = alarmRepository;
        this.calendarRepository = calendarRepository;
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

    public List<NewAlarmResponse> getNewAlarm() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        LocalDate date = LocalDate.now().plusDays(1);
        List<Calendar> calendars = calendarRepository.findCalendarByUserIdAndDate(userId, date);
        if (calendars.isEmpty()) {
            throw new RuntimeException("No alarm tomorrow");
        }
        return calendars.stream()
                .map(calendar -> new NewAlarmResponse(calendar.getSubject(), calendar.getDate()))
                .collect(Collectors.toList());

    }

    public List<RecentAlarmResponse> getRecentAlarm() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        LocalDate endDate = LocalDate.now().minusDays(1); // 어제
        LocalDate startDate = endDate.minusDays(6); // 7일 전

        List<Calendar> calendars = calendarRepository.findCalendarByUserIdAndDateBetween(userId, startDate, endDate);
        if (calendars.isEmpty()) {
            throw new RuntimeException("No alarm recent 7days");
        }
        return calendars.stream()
                .map(calendar -> new RecentAlarmResponse(calendar.getSubject(), calendar.getDate()))
                .collect(Collectors.toList());
    }



}
