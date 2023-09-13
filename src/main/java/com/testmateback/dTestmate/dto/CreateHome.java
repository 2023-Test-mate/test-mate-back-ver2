package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.Home;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class CreateHome {
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
        private String semester;
        @NotNull
        private String fail;
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
        private String semester;
        @NotNull
        private String fail;

        public static CreateHome.Response homeResponse(Home home) {
            return Response.builder()
                    .subject(home.getSubject())
                    .semester(home.getSemester())
                    .fail(home.getFail())
                    .build();
        }
    }
}
