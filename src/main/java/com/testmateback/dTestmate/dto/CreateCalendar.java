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
        private String subject;
        @NotNull
        private String date;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String subject;
        @NotNull
        private String date;


        public static CreateCalendar.Response calendarResponse(Calendar calendar) {
            return Response.builder()
                    .subject(calendar.getSubject())
                    .date(calendar.getDate())
                    .build();
        }
    }
}
