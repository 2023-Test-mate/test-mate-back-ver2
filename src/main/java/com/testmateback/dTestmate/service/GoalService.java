
package com.testmateback.dTestmate.service;


import com.testmateback.dTestmate.dto.CreateGoal;
import com.testmateback.dTestmate.entity.Goal;
import com.testmateback.dTestmate.repository.GoalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoalService {
    private final GoalRepository goalRepository;

    public GoalService(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Transactional
    public CreateGoal.Response createGoal(CreateGoal.Request request){
        Goal goal = Goal.builder()
                .index(request.getIndex())
                .goal_subject(request.getGoal_subject())
                .goal_semester(request.getGoal_semester())
                .goal(request.getGoal())
                .goal_check(request.isGoal_check())
                .build();

        goalRepository.save(goal);

        return CreateGoal.Response.GoalResponse(goal);
    }
}