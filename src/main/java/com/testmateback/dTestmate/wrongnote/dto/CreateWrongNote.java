package com.testmateback.dTestmate.wrongnote.dto;

import com.testmateback.dTestmate.wrongnote.WrongNote;
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
        private String title;
        @NotNull
        private String grade;
        @NotNull
        private String problem;
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
        private boolean reasoncheck;
        @NotNull
        private boolean scopecheck;

        public boolean getReasoncheck() {
            return reasoncheck;
        }

        public boolean getScopecheck() {
            return scopecheck;
        }
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
        private String title;
        @NotNull
        private String grade;
        @NotNull
        private String problem;
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
        private boolean reasoncheck;
        @NotNull
        private boolean scopecheck;

        public static CreateWrongNote.Response WrongNoteResponse(WrongNote wrongNote) {
            return Response.builder()
                    .subject(wrongNote.getSubject())
                    .grade(wrongNote.getGrade())
                    .solution(wrongNote.getSolution())
                    .problem(wrongNote.getProblem())
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