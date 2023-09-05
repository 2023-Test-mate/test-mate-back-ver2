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
        private String index;
        @NotNull
        private String note_subject;
        @NotNull
        private String note_semester;
        @NotNull
        private byte[] note_photo;
        @NotNull
        private String note_solution;
        @NotNull
        private String note_testStyle;
        @NotNull
        private String note_reason;
        @NotNull
        private String note_testScope;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String note_subject;
        @NotNull
        private String note_semester;
        @NotNull
        private byte[] note_photo;
        @NotNull
        private String note_solution;
        @NotNull
        private String note_testStyle;
        @NotNull
        private String note_reason;
        @NotNull
        private String note_testScope;

        public static CreateWrongNote.Response WrongNoteResponse(WrongNote wrongNote) {
            return CreateWrongNote.Response.builder()
                    .note_subject(wrongNote.getNote_subject())
                    .note_semester(wrongNote.getNote_semester())
                    .note_photo(wrongNote.getNote_photo())
                    .note_solution(wrongNote.getNote_solution())
                    .note_testStyle(wrongNote.getNote_testStyle())
                    .note_reason(wrongNote.getNote_reason())
                    .note_testScope(wrongNote.getNote_testScope())
                    .build();
        }
    }
}