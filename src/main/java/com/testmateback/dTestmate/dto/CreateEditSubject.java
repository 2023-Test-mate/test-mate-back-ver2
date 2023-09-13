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
        private String subject;
        @NotNull
        private byte[] photo;

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
        private byte[] photo;

        public static CreateEditSubject.Response EditSubjectResponse(EditSubject editSubject) {
            return Response.builder()
                    .subject(editSubject.getSubject())
                    .photo(editSubject.getPhoto())
                    .build();
        }
    }
}