package com.testmateback.dTestmate.calendar;

import com.testmateback.dTestmate.calendar.repository.CalenderRepository;
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
                .indexes(request.getIndexes())
                .subject(request.getSubject())
                .date(request.getDate())
                .build();

        calenderRepository.save(calendar);

        return CreateCalendar.Response.calendarResponse(calendar);
    }

}
