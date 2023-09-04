package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.Users;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

// CreateUser 클래스 정의
public class CreateUser {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    // Request 클래스 정의
    public static class Request {
        @NotNull // name 필드는 null이 아니어야 함
        private String name;
        @NotNull // email 필드는 null이 아니어야 함
        private String email;
        @NotNull // grade 필드는 null이 아니어야 함
        private String grade;
        @NotNull // password 필드는 null이 아니어야 함
        @Size(min = 8, max = 20, message = "password size must be 8~20") // password의 길이가 8에서 20 사이여야 함
        private String password;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    // Response 클래스 정의
    public static class Response {
        @NotNull // name 필드는 null이 아니어야 함
        private String name;
        @NotNull // email 필드는 null이 아니어야 함
        private String email;
        @NotNull // grade 필드는 null이 아니어야 함
        private String grade;

        // Users 엔티티에서 Response 객체를 생성하는 정적 메서드
        public static Response userResponse(Users user) {
            return Response.builder()
                    .name(user.getName())    // Users 엔티티의 이름 값을 가져와서 설정
                    .email(user.getEmail())  // Users 엔티티의 이메일 값을 가져와서 설정
                    .grade(user.getGrade())  // Users 엔티티의 등급 값을 가져와서 설정
                    .build();                // Response 객체를 빌드하여 반환
        }
    }
}
