package com.testmateback.domain.goal.service;

import com.testmateback.domain.goal.entity.Goal;
import com.testmateback.domain.goal.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    public Goal createGoal(Goal goal) {
        return goalRepository.save(goal);
    }

    public List<Goal> getGoalsBySubjectIdAndSemester(int subjectId, int semester) {
        return goalRepository.findBySubjectIdAndSemester(subjectId, semester);
    }

    public Goal updateGoal(Long goalId, Goal goalDetails) {
        Goal goal = goalRepository.findById(goalId)
                .orElseThrow(() -> new RuntimeException("Goal not found with id: " + goalId));

        goal.setGoal(goalDetails.getGoal());
        goal.setCompleted(goalDetails.isCompleted());

        return goalRepository.save(goal);
    }

    public void deleteGoal(Long goalId) {
        goalRepository.deleteById(goalId);
    }
}