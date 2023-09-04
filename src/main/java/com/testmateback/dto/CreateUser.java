package com.testmateback.dto;

import com.testmateback.entity.Users;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

public class CreateUser {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull
        private String name;
        @NotNull
        private String email;
        @NotNull
        private String grade;
        @NotNull
        @Size(min = 8, max = 20, message = "password size must 8~20")
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String name;
        @NotNull
        private String email;
        @NotNull
        private String grade;

        public static Response userResponse(Users user) {
            return Response.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .grade(user.getGrade())
                    .build();
        }
    }

}
