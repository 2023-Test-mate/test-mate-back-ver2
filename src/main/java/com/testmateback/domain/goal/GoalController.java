package com.testmateback.domain.goal;

import com.testmateback.domain.goal.entity.Goal;
import com.testmateback.domain.goal.service.GoalService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
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
    public ResponseEntity<ResponseMessage> createGoal(@RequestBody Goal goal) {
        goalService.createGoal(goal);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_CREATE.getMessage()));
    }

    // GET API - subjectId와 semester에 해당하는 모든 Goal을 가져옵니다.
    @GetMapping("/{subjectId}/{semester}")
    public ResponseEntity<List<Goal>> getGoals(@PathVariable int subjectId, @PathVariable int semester) {
        List<Goal> goals = goalService.getGoalsBySubjectIdAndSemester(subjectId, semester);
        return new ResponseEntity<>(goals, HttpStatus.OK);
    }

    // PUT API - goalId를 받아서 Goal을 업데이트합니다.
    @PatchMapping("/{goalId}")
    public ResponseEntity<ResponseMessage> updateGoal(@PathVariable Long goalId, @RequestBody Goal goalDetails) {
        Goal updatedGoal = goalService.updateGoal(goalId, goalDetails);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));
    }

    // DELETE API - goalId를 받아서 해당 Goal을 삭제합니다.
    @DeleteMapping("/{goalId}")
    public ResponseEntity<ResponseMessage> deleteGoal(@PathVariable Long goalId) {
        goalService.deleteGoal(goalId);
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_DELETE.getMessage()));
    }
}