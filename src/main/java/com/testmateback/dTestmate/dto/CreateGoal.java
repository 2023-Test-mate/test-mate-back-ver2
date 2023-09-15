package com.testmateback.dTestmate.dto;

import com.testmateback.dTestmate.entity.Goal;
import jakarta.validation.constraints.NotNull;
import lombok.*;

public class CreateGoal {
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
        private String grade;
        @NotNull
        private String goal;
        @NotNull
        private boolean checks;


        public boolean getCheck() {
            return checks;
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
        private String grade;
        @NotNull
        private String goal;
        @NotNull
        private boolean checks;

        public static CreateGoal.Response GoalResponse(Goal goal) {
            return Response.builder()
                    .subject(goal.getGoal())
                    .grade(goal.getGrade())
                    .goal(goal.getGoal())
                    .checks(goal.getCheck())
                    .build();
        }
    }
}