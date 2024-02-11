package com.testmateback.dTestmate.calendar.service;

import com.testmateback.dTestmate.calendar.dto.CreateTestInfoReq;
import com.testmateback.dTestmate.calendar.entity.Calendar;
import com.testmateback.dTestmate.calendar.repository.CalendarRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarService {

    private final CalendarRepository calenderRepository;
    private final HttpSession session;
    private final static String LOGIN_SESSION_KEY = "USER_ID";


    public CalendarService(CalendarRepository calenderRepository, HttpSession session) {
        this.calenderRepository = calenderRepository;
        this.session = session;
    }

    // 캘린더 생성
    public Calendar addTestInfo(CreateTestInfoReq createTestInfoReq){
        Long currentUserId = getCurrentUserIdFromSession();
        Calendar calendar = new Calendar();
        calendar.setUserId(currentUserId);
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

    private Long getCurrentUserIdFromSession() {
        // 세션에서 사용자 ID를 가져오는 로직
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }


}
