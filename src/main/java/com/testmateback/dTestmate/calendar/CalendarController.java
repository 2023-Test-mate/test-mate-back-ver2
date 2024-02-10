package com.testmateback.dTestmate.calendar;

import com.testmateback.dTestmate.calendar.dto.CreateTestInfoReq;
import com.testmateback.dTestmate.calendar.entity.Calendar;
import com.testmateback.dTestmate.calendar.service.CalendarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/calendar")
public class CalendarController {

    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
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

}
