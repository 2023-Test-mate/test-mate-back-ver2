package com.testmateback.domain.goal;

import com.testmateback.domain.goal.entity.Goal;
import com.testmateback.domain.goal.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalService goalService;

    // POST API -
    @PostMapping
    public ResponseEntity<Goal> createGoal(@RequestBody Goal goal) {
        Goal createdGoal = goalService.createGoal(goal);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }

    // GET API - subjectId와 semester에 해당하는 모든 Goal을 가져옵니다.
    @GetMapping("/{subjectId}/{semester}")
    public ResponseEntity<List<Goal>> getGoals(@PathVariable int subjectId, @PathVariable int semester) {
        List<Goal> goals = goalService.getGoalsBySubjectIdAndSemester(subjectId, semester);
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    // PUT API - goalId를 받아서 Goal을 업데이트합니다.
    @PatchMapping("/{goalId}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long goalId, @RequestBody Goal goalDetails) {
        Goal updatedGoal = goalService.updateGoal(goalId, goalDetails);
        return new ResponseEntity<>(updatedGoal, HttpStatus.OK);
    }

    // DELETE API - goalId를 받아서 해당 Goal을 삭제합니다.
    @DeleteMapping("/{goalId}")
    public ResponseEntity<?> deleteGoal(@PathVariable Long goalId) {
        goalService.deleteGoal(goalId);
        return ResponseEntity.ok().build();
    }
}