package com.testmateback.domain.calendar;

import com.testmateback.domain.calendar.dto.CreateTestInfoReq;
import com.testmateback.domain.calendar.entity.Calendar;
import com.testmateback.domain.calendar.service.CalendarService;
import com.testmateback.domain.util.SessionUtil;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
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

    /*
        @ 달력에서 시험 일정 추가
        post api/calendar
     */
    @PostMapping
    public ResponseEntity<ResponseMessage> createTestInfo(@RequestBody CreateTestInfoReq createTestInfoReq) {
        calendarService.addTestInfo(createTestInfoReq);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
    }

    /*
        @ 달력에서 모든 일정 보여주기 - 유저아이디 필요
        get api/calendar

     */

    @GetMapping
    public List<Calendar> getAllCalendarsByUserId() {
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
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
        Long userId = SessionUtil.getCurrentUserIdFromSession(session);
        return calendarService.getCalendarByUserIdAndDate(userId, date);
    }

    /*
        @ 달력에서 시험 일정 삭제
        delete api/calendar/:calendarId
    */
    @DeleteMapping("/{calendarId}")
    public ResponseEntity<ResponseMessage> deleteCalendar(@PathVariable Long calendarId) {
        calendarService.deleteCalendar(calendarId);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_DELETE.getMessage()));

    }

}
