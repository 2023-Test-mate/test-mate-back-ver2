package com.testmateback.dTestmate.calendar.service;

import com.testmateback.dTestmate.calendar.dto.CreateTestInfoReq;
import com.testmateback.dTestmate.calendar.entity.Calendar;
import com.testmateback.dTestmate.calendar.repository.CalendarRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class CalendarService {

    private final CalendarRepository calenderRepository;
    private final HttpSession session;
    private final static String LOGIN_SESSION_KEY = "USER_ID";


    public CalendarService(CalendarRepository calenderRepository, HttpSession session) {
        this.calenderRepository = calenderRepository;
        this.session = session;
    }

    public Calendar addTestInfo(CreateTestInfoReq createTestInfoReq){
        Long currentUserId = getCurrentUserIdFromSession();
        Calendar calendar = new Calendar();
        calendar.setUserId(currentUserId);
        calendar.setSubject(createTestInfoReq.getSubject());
        calendar.setDate(createTestInfoReq.getDate());
        return calenderRepository.save(calendar);
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
