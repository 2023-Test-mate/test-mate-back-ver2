package com.testmateback.domain.calendar.service;

import com.testmateback.domain.calendar.dto.CreateTestInfoReq;
import com.testmateback.domain.calendar.entity.Calendar;
import com.testmateback.domain.calendar.repository.CalendarRepository;
import com.testmateback.domain.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarService {

    private final CalendarRepository calenderRepository;
    private final HttpSession session;


    public CalendarService(CalendarRepository calenderRepository, HttpSession session) {
        this.calenderRepository = calenderRepository;
        this.session = session;
    }

    // 캘린더 생성
    public Calendar addTestInfo(CreateTestInfoReq createTestInfoReq){
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        Calendar calendar = new Calendar();
        calendar.setUserId(userId);
        calendar.setSubject(createTestInfoReq.getSubject());
        calendar.setDate(createTestInfoReq.getDate());
        return calenderRepository.save(calendar);
    }

    // 캘린더 삭제
    public void deleteCalendar(Long calendarId) {
        calenderRepository.deleteById(calendarId);
    }

    // 로그인한 유저의 일정 목록 불러오기
    public List<Calendar> getAllCalendarsByUserId(Long userId) {
        return calenderRepository.findByUserId(userId);
    }

    // 로그인한 유저의 날짜별 일정 목록 불러오기
    public List<Calendar> getCalendarByUserIdAndDate(Long userId, LocalDate date) {
        return calenderRepository.findByUserIdAndDate(userId, date);
    }


}
