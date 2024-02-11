package com.testmateback.dTestmate.calendar;

import com.testmateback.dTestmate.calendar.dto.CreateTestInfoReq;
import com.testmateback.dTestmate.calendar.entity.Calendar;
import com.testmateback.dTestmate.calendar.service.CalendarService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/calendar")
public class CalendarController {

    private final CalendarService calendarService;
    private final HttpSession session;


    public CalendarController(CalendarService calendarService, HttpSession session) {
        this.calendarService = calendarService;
        this.session = session;
    }

    private final static String LOGIN_SESSION_KEY = "USER_ID";

    private Long getCurrentUserIdFromSession() {
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }

    /*
        @ 달력에서 시험 일정 추가
        post api/calendar
     */
    @PostMapping
    public ResponseEntity<Calendar> createTestInfo(@RequestBody CreateTestInfoReq createTestInfoReq) {
        Calendar newInfo = calendarService.addTestInfo(createTestInfoReq);
        return ResponseEntity.ok(newInfo);
    }

    /*
        @ 달력에서 모든 일정 보여주기 - 유저아이디 필요
        get api/calendar

     */

    @GetMapping
    public List<Calendar> getAllCalendarsByUserId() {
        Long userId = getCurrentUserIdFromSession();
        return calendarService.getAllCalendarsByUserId(userId);
    }

    /*
        @ 달력에서 날짜별 일정 보여주기 - 유저아이디 필요
        get api/calendar/:date
     */

    @GetMapping("/{date}")
    public List<Calendar> getCalendarByUserIdAndDate(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        Long userId = getCurrentUserIdFromSession();
        return calendarService.getCalendarByUserIdAndDate(userId, date);
    }

    /*
        @ 달력에서 시험 일정 삭제
        delete api/calendar/:calendarId
    */
    @DeleteMapping("/{calendarId}")
    public ResponseEntity<?> deleteCalendar(@PathVariable Long calendarId) {
        calendarService.deleteCalendar(calendarId);
        return ResponseEntity.ok().build();
    }

}
