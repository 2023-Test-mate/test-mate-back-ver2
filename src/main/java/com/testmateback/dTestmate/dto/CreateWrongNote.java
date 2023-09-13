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
        private String styles;
        @NotNull
        private String reason;
        @NotNull
        private String scopes;
        @NotNull
        private String reasoncheck;
        @NotNull
        private String scopecheck;
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
        private String styles;
        @NotNull
        private String reason;
        @NotNull
        private String scopes;
        @NotNull
        private String reasoncheck;
        @NotNull
        private String scopecheck;

        public static CreateWrongNote.Response WrongNoteResponse(WrongNote wrongNote) {
            return Response.builder()
                    .subject(wrongNote.getSubject())
                    .semester(wrongNote.getSemester())
                    .photo(wrongNote.getPhoto())
                    .solution(wrongNote.getSolution())
                    .styles(wrongNote.getStyles())
                    .reason(wrongNote.getReason())
                    .scopes(wrongNote.getScopes())
                    .reasoncheck(wrongNote.getReasoncheck())
                    .scopecheck(wrongNote.getScopecheck())
                    .build();
        }
    }
}