package com.testmateback.dTestmate.goal;

import com.testmateback.dTestmate.dao.GoalCheckResponse;
import com.testmateback.dTestmate.goal.repository.GoalRepository;
import com.testmateback.dTestmate.subject.EditSubject;
import com.testmateback.dTestmate.subject.TestInfo;
import com.testmateback.dTestmate.subject.repository.EditSubjectRepository;
import com.testmateback.dTestmate.testinfo.TestInfoRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequestMapping("/goal")
@RestController
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;
    @Autowired
    private TestInfoRepository testInfoRepository;
    @Autowired
    private EditSubjectRepository editSubjectRepository; // EditSubject 테이블에 접근하기 위한 리포지토리 추가

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    // 목표 정보 생성 요청 처리
    @PostMapping
    public CreateGoal.Response createGoal(
            @Valid @RequestBody CreateGoal.Request request
    ) {
        log.info("request : {} ", request);
        return goalService.createGoal(request);
    }


    // 목표 관련 기능에 대한 컨트롤러 코드
    @GetMapping("/details")
    public List<GoalDetails> getGoalDetails(@RequestParam String indexes) {
        List<GoalDetails> goalDetailsList = new ArrayList<>();

        // testInfoRepository 인스턴스를 사용하여 findByIndexes 메서드 호출
        List<TestInfo> testInfoList = testInfoRepository.findByIndexes(indexes);

        EditSubject editSubject = editSubjectRepository.findBySubject(indexes);

        for (TestInfo testInfo : testInfoList) {
            GoalDetails goalDetails = new GoalDetails();
            goalDetails.setIndexes(indexes);

            // EditSubject가 null이 아닌 경우에만 값을 설정합니다.
            if (editSubject != null) {
                goalDetails.setGoalSubject(editSubject.getSubject());
                goalDetails.setSubjectImg(editSubject.getPhoto());
            }

            goalDetails.setGoalGrade(testInfo.getGrade());

            // goalRepository를 사용하여 해당 subject의 goal 개수를 구합니다.
            List<Goal> goalsBySubject = goalRepository.findBySubject(goalDetails.getGoalSubject());
            List<Goal> checkedGoalsBySubject = goalRepository.findBySubjectAndChecksTrue(goalDetails.getGoalSubject());

            goalDetails.setTotalGoals(goalsBySubject.size());
            goalDetails.setCheckedGoals(checkedGoalsBySubject.size());
            goalDetailsList.add(goalDetails);
        }

        return goalDetailsList;
    }


    @GetMapping("/check-lists")
    public GoalCheckResponse getGoalCheck(
            @RequestParam String indexes,
            @RequestParam String subject,
            @RequestParam String grade
    ) {
        try {
            List<Goal> checkedGoals = goalRepository.findByIndexesAndSubjectAndGradeAndChecks(indexes, subject, grade, true);
            List<Goal> noGoals = goalRepository.findByIndexesAndSubjectAndGradeAndChecks(indexes, subject, grade, false);

            GoalCheckResponse response = new GoalCheckResponse();
            response.setCheckedGoals(checkedGoals.stream().map(Goal::getGoal).collect(Collectors.toList()));
            response.setNoGoals(noGoals.stream().map(Goal::getGoal).collect(Collectors.toList()));

            return response;
        } catch (Exception e) {
            // 예외 처리: 예외가 발생할 경우 에러 응답을 반환하거나 로깅 등을 수행할 수 있습니다.
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch goals");
        }
    }


    @DeleteMapping("/{id}")
    public void deleteGoalById(@PathVariable Long id) {
        goalRepository.deleteById(id);
    }

    @DeleteMapping("/delete-by-conditions")
    public void deleteGoalByConditions(
            @RequestParam String indexes,
            @RequestParam String subject,
            @RequestParam String grade,
            @RequestParam String goal) {

        goalRepository.deleteByIndexesAndSubjectAndGradeAndGoal(indexes, subject, grade, goal);
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateGoal(
            @PathVariable Long id,
            @RequestBody Goal updatedGoal) {

        Optional<Goal> goalOptional = goalRepository.findById(id);

        if (goalOptional.isPresent()) {
            Goal existingGoal = goalOptional.get();

            // 업데이트할 필드 설정
            existingGoal.setIndexes(updatedGoal.getIndexes());
            existingGoal.setSubject(updatedGoal.getSubject());
            existingGoal.setGrade(updatedGoal.getGrade());
            existingGoal.setGoal(updatedGoal.getGoal());
            existingGoal.setChecks(updatedGoal.isChecks());

            // 엔터티를 저장하여 업데이트 적용
            goalRepository.save(existingGoal);

            return ResponseEntity.ok("Goal 엔터티가 업데이트되었습니다.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

