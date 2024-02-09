
package com.testmateback.dTestmate.goal;


import com.testmateback.dTestmate.goal.repository.GoalRepository;
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
                .indexes(request.getIndexes())
                .subject(request.getSubject())
                .grade(request.getGrade())
                .goal(request.getGoal())
                .checks(request.getCheck())
                .build();

        goalRepository.save(goal);

        return CreateGoal.Response.GoalResponse(goal);
    }
}