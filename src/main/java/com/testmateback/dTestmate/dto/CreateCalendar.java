package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.Calendar;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class CreateCalendar {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull
        private String indexes;
        @NotNull
        private String calendar_subject;
        @NotNull
        private String calendar_date;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String calendar_subject;
        @NotNull
        private String calendar_date;


        public static CreateCalendar.Response calendarResponse(Calendar calendar) {
            return CreateCalendar.Response.builder()
                    .calendar_subject(calendar.getCalendar_subject())
                    .calendar_date(calendar.getCalendar_date())
                    .build();
        }
    }
}
