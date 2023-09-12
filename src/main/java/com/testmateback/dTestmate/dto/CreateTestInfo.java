package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.TestInfo;
import jakarta.persistence.Column;
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
        private String test_subject;
        @NotNull
        private String test_semester;
        @NotNull
        private int test_score;
        @NotNull
        private String test_date;
        @NotNull
        private String test_level;
        @NotNull
        private int test_target;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String test_subject;
        @NotNull
        private String test_semester;
        @NotNull
        private int test_score;
        @NotNull
        private String test_date;
        @NotNull
        private String test_level;
        @NotNull
        private int test_target;

        public static CreateTestInfo.Response TestInfoResponse(TestInfo testInfo) {
            return CreateTestInfo.Response.builder()
                    .test_subject(testInfo.getTest_subject())
                    .test_semester(testInfo.getTest_semester())
                    .test_score(testInfo.getTest_score())
                    .test_date(testInfo.getTest_date())
                    .test_level(testInfo.getTest_level())
                    .test_target(testInfo.getTest_target())
                    .build();
        }
    }
}