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
        private String home_subject;
        @NotNull
        private String home_semester;
        @NotNull
        private String home_fail;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String home_subject;
        @NotNull
        private String home_semester;
        @NotNull
        private String home_fail;

        public static CreateHome.Response homeResponse(Home home) {
            return CreateHome.Response.builder()
                    .home_subject(home.getHome_subject())
                    .home_semester(home.getHome_semester())
                    .home_fail(home.getHome_fail())
                    .build();
        }
    }
}
