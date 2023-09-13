package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.WrongNote;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class CreateWrongNote {
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
        private byte[] photo;
        @NotNull
        private String solution;
        @NotNull
        private String testStyle;
        @NotNull
        private String reason;
        @NotNull
        private String testScope;
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
        private byte[] photo;
        @NotNull
        private String solution;
        @NotNull
        private String testStyle;
        @NotNull
        private String reason;
        @NotNull
        private String testScope;

        public static CreateWrongNote.Response WrongNoteResponse(WrongNote wrongNote) {
            return CreateWrongNote.Response.builder()
                    .subject(wrongNote.getSubject())
                    .semester(wrongNote.getSemester())
                    .photo(wrongNote.getPhoto())
                    .solution(wrongNote.getSolution())
                    .testStyle(wrongNote.getTestStyle())
                    .reason(wrongNote.getReason())
                    .testScope(wrongNote.getTestScope())
                    .build();
        }
    }
}