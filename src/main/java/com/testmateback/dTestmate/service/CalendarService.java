package com.testmateback.dTestmate.service;

import com.testmateback.dTestmate.dto.CreateCalendar;
import com.testmateback.dTestmate.entity.Calendar;
import com.testmateback.dTestmate.repository.CalenderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalendarService {

    private final CalenderRepository calenderRepository;

    public CalendarService(CalenderRepository calenderRepository) {
        this.calenderRepository = calenderRepository;
    }

    @Transactional
    public CreateCalendar.Response createCalendar(CreateCalendar.Request request){
        Calendar calendar = Calendar.builder()
                .index(request.getIndex())
                .calendar_subject(request.getCalendar_subject())
                .calendar_date(request.getCalendar_date())
                .build();

        calenderRepository.save(calendar);

        return CreateCalendar.Response.calendarResponse(calendar);
    }

}
