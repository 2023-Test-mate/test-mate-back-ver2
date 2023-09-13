package com.testmateback.dTestmate.controller;

import com.testmateback.dTestmate.dto.*;
import com.testmateback.dTestmate.entity.*;
import com.testmateback.dTestmate.repository.EditSubjectRepository;
import com.testmateback.dTestmate.repository.GoalRepository;
import com.testmateback.dTestmate.repository.TestInfoRepository;
import com.testmateback.dTestmate.repository.UserRepository;
import com.testmateback.dTestmate.service.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DMakerController {
    private final UserService userService;
    private final HomeService homeService;
    private final CalendarService calendarService;
    private final GoalService goalService;
    private final EditSubjectService editSubjectService;
    private final TestInfoService testInfoService;
    private final WrongNoteService wrongNoteService;


    @PostMapping("/sign-up")
    public CreateUser.Response createUser(
            @Valid @RequestBody CreateUser.Request request
    ) {
        log.info("request : {}", request);
        return userService.createUser(request);
    }

    @RestController
    @RequestMapping("/api")
    public class AuthController {

        @Autowired
        private UserRepository userRepository;

        @PostMapping("/login")
        public ResponseEntity<Map<String, String>> login(@RequestBody CreateUser.Request credentials) {
            String email = credentials.getEmail();
            String password = credentials.getPassword();

            // 이메일로 사용자 찾기
            Users user = userRepository.findByEmail(email);
            if (user == null || !user.getPassword().equals(password)) {
                Map<String, String> response = new HashMap<>();
                response.put("message", "로그인 실패");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // 로그인 성공
            Map<String, String> response = new HashMap<>();
            response.put("message", "로그인 성공");
            return ResponseEntity.ok(response);
        }
    }

    @PostMapping("/home")
    public CreateHome.Response createHome(
            @Valid @RequestBody CreateHome.Request request
    ) {
        log.info("request : {}", request);
        return homeService.createHome(request);

    }

    @PostMapping("/calendar")
    public CreateCalendar.Response createCalendar(
            @Valid @RequestBody CreateCalendar.Request request
    ) {
        log.info("request : {}", request);
        return calendarService.createCalendar(request);

    }

    @PostMapping("/edit-subject")
    public CreateEditSubject.Response createEditSubject(
            @Valid @RequestBody CreateEditSubject.Request request
    ) {
        log.info("request : {}", request);
        return editSubjectService.createEditSubject(request);
    }

    @PostMapping("/goal")
    public CreateGoal.Response createGoal(
            @Valid @RequestBody CreateGoal.Request request
    ) {
        log.info("request : {} ", request);
        return goalService.createGoal(request);
    }

    @PostMapping("/test-info")
    public CreateTestInfo.Response createTestInfo(
            @Valid @RequestBody CreateTestInfo.Request request
    ) {
        log.info("request : {} ", request);
        return testInfoService.createTestInfo(request);
    }

    @PostMapping("/wrong-note")
    public CreateWrongNote.Response createWrongNote(
            @Valid @RequestBody CreateWrongNote.Request request
    ) {
        log.info("request : {} ", request);
        return wrongNoteService.createWrongNote(request);
    }

//    @RestController
//    @RequestMapping("/goal")
//    public class GoalController {
//
//        @Autowired
//        private GoalRepository goalRepository;
//
//        @Autowired
//        private TestInfoRepository testInfoRepository;
//
//        @GetMapping("/details")
//        public GoalDetails getGoalDetails(@RequestParam String indexes) {
//            GoalDetails goalDetails = new GoalDetails();
//
//            // indexes 값으로 TestInfo 엔터티를 찾아옴
//            TestInfo testInfo = testInfoRepository.findByIndexes(indexes).orElse(null);
//
//            if (testInfo != null) {
//                goalDetails.setGoalSubject(testInfo.getTest_subject());
//                goalDetails.setGoalSemester(testInfo.getTest_semester());
//            }
//
//            goalDetails.setTotalGoals(goalRepository.count());
//            // goalDetails.setCheckedGoals(goalRepository.countByGoal_checkIsTrue());
//
//            return goalDetails;
//        }
//    }
}
