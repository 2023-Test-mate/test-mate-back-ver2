package com.testmateback.dTestmate.controller;

import com.testmateback.dTestmate.dto.CreateCalendar;
import com.testmateback.dTestmate.entity.Calendar;
import com.testmateback.dTestmate.entity.CalendarDetails;
import com.testmateback.dTestmate.repository.CalenderRepository;
import com.testmateback.dTestmate.service.CalendarService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/calendar")
public class CalendarController {

    @Autowired
    private CalenderRepository calenderRepository;
    private final CalendarService calendarService;

    public CalendarController(CalendarService calendarService) {
        this.calendarService = calendarService;
    }



    // 캘린더 정보 생성 요청 처리
    @PostMapping
    public CreateCalendar.Response createCalendar(
            @Valid @RequestBody CreateCalendar.Request request
    ) {
        log.info("request : {}", request);
        return calendarService.createCalendar(request);

    }

    // 캘린더 관련 기능을 처리하는 컨트롤러 클래스
    @GetMapping("/details")
    public List<CalendarDetails> getCalendarDetails(@RequestParam String indexes) {
        // indexes에 해당하는 모든 결과를 가져옵니다.
        List<Calendar> calendars = calenderRepository.findByIndexes(indexes);

        List<CalendarDetails> calendarDetailsList = new ArrayList<>();

        for (Calendar calendar : calendars) {
            CalendarDetails calendarDetails = new CalendarDetails();
            calendarDetails.setSubjectdate(calendar.getDate());
            calendarDetails.setCsubject(calendar.getSubject());
            calendarDetailsList.add(calendarDetails);
        }

        return calendarDetailsList;
    }

    @Transactional
    @DeleteMapping("/delete")
    public String deleteCalendar(@RequestParam String indexes, @RequestParam String subject, @RequestParam String date) {
        Calendar calendar = calenderRepository.deleteByIndexesAndSubjectAndDate(indexes, subject, date);

        try {
            if (calendar != null) {
                calenderRepository.delete(calendar);
                return "Deleted successfully";
            } else {
                return "WrongNote not found";
            }
        } catch (Exception e) {
            return "Failed to delete";
        }
    }
}
