package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.TestInfo;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class CreateTestInfo {
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
        private String grade;
        @NotNull
        private int score;
        @NotNull
        private String dates;
        @NotNull
        private String levels;
        @NotNull
        private int target;
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
        private String grade;
        @NotNull
        private int score;
        @NotNull
        private String dates;
        @NotNull
        private String levels;
        @NotNull
        private int target;

        public static CreateTestInfo.Response TestInfoResponse(TestInfo testInfo) {
            return Response.builder()
                    .subject(testInfo.getSubject())
                    .grade(testInfo.getGrade())
                    .score(testInfo.getScore())
                    .dates(testInfo.getDates())
                    .levels(testInfo.getLevels())
                    .target(testInfo.getTarget())
                    .build();
        }
    }
}