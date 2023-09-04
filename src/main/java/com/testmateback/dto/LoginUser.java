package com.testmateback.dto;

import com.testmateback.entity.Users;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class LoginUser {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginRequest {
        @NotNull
        private String email;
        @NotNull
        private String password;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResponse {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        protected Long id;

        @NotNull
        private String name;
        @NotNull
        private String email;
        @NotNull
        private String grade;


        public static LoginResponseBuilder builder() {
            return new LoginResponseBuilder();
        }

        public static class LoginResponseBuilder {
            private Long id;
            private String name;
            private String email;
            private String grade;

            public LoginResponseBuilder id(Long id) {
                this.id = id;
                return this;
            }

            public LoginResponseBuilder name(String name) {
                this.name = name;
                return this;
            }

            public LoginResponseBuilder email(String email) {
                this.email = email;
                return this;
            }

            public LoginResponseBuilder grade(String grade) {
                this.grade = grade;
                return this;
            }

            public LoginResponse build() {
                return new LoginResponse(id, name, email, grade);
            }
        }
    }


}
