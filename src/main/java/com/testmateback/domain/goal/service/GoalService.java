package com.testmateback.domain.goal.service;

import com.testmateback.domain.goal.dto.GoalSubjectsDTO;
import com.testmateback.domain.goal.entity.Goal;
import com.testmateback.domain.goal.repository.GoalRepository;
import com.testmateback.domain.subject.entity.Subject;
import com.testmateback.domain.subject.repository.SubjectRepository;
import com.testmateback.domain.util.SessionUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GoalService {

    @Autowired
    private GoalRepository goalRepository;

    private final SubjectRepository subjectRepository;
    private final HttpSession session;
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

    // 홈 - 학년 정보에 해당하는 과목 리스트 가져오기
    public List<GoalSubjectsDTO> getSubjectInfo(int grade) {
        Long currentUserId = SessionUtil.getCurrentUserIdFromSession(session);
        List<Subject> subjects = subjectRepository.findByUserIdAndGrade(currentUserId, grade);

        return subjects.stream()
                .map(subject -> {
                    int recentSemester = goalRepository.findTopBySubjectIdOrderByLastModifiedDateDesc(subject.getSubjectId().intValue())
                            .map(Goal::getSemester)
                            .orElse(0); // 만약 Goal이 없다면 기본값 0 설정
                    return new GoalSubjectsDTO(subject.getSubjectId(), subject.getSubjectName(), subject.getImg(), recentSemester);
                })
                .collect(Collectors.toList());
    }

    public void deleteGoal(Long goalId) {
        goalRepository.deleteById(goalId);
    }
}