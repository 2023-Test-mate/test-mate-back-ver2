package com.testmateback.dTestmate.dto;

        import com.testmateback.dTestmate.entity.Goal;
        import com.testmateback.dTestmate.entity.Home;
        import jakarta.persistence.Column;
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
        private String goal_subject;
        @NotNull
        private String goal_semester;
        @NotNull
        private String goal;
        @NotNull
        private boolean goal_check;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ToString
    public static class Response {
        @NotNull
        private String goal_subject;
        @NotNull
        private String goal_semester;
        @NotNull
        private String goal;
        @NotNull
        private boolean goal_check;

        public static CreateGoal.Response GoalResponse(Goal goal) {
            return CreateGoal.Response.builder()
                    .goal_subject(goal.getGoal_subject())
                    .goal_semester(goal.getGoal_semester())
                    .goal(goal.getGoal())
                    .goal_check(goal.isGoal_check())
                    .build();
        }
    }
}