package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.EditSubject;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class CreateEditSubject {
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
        private String edit_subject;
        @NotNull
        private byte[] edit_photo;

    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String edit_subject;
        @NotNull
        private byte[] edit_photo;

        public static CreateEditSubject.Response EditSubjectResponse(EditSubject editSubject) {
            return Response.builder()
                    .edit_subject(editSubject.getEdit_subject())
                    .edit_photo(editSubject.getEdit_photo())
                    .build();
        }
    }
}