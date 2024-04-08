package com.testmateback.dTestmate.alarm;

import com.testmateback.dTestmate.alarm.dto.AlarmDTO;
import com.testmateback.dTestmate.alarm.entity.Alarm;
import com.testmateback.dTestmate.alarm.service.AlarmService;
import com.testmateback.dTestmate.subject.dto.CreateSubject;
import com.testmateback.dTestmate.subject.entity.Subject;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alarm")
public class AlarmController {
    private final AlarmService alarmService;
    private final HttpSession session;

    private final static String LOGIN_SESSION_KEY = "USER_ID";

    public AlarmController(AlarmService alarmService, HttpSession session) {
        this.alarmService = alarmService;
        this.session = session;
    }


    @GetMapping("/status/{userId}")
    public ResponseEntity<Boolean> getAlarmStatusByUserId(@PathVariable Long userId) {
        boolean completedValue = alarmService.getAlarmStatusByUserId(userId);
        return ResponseEntity.ok(completedValue);
    }

    @PatchMapping("/update_alarm/{userId}/{completed}")
    public ResponseEntity<String> updateCompletedValue(@PathVariable Long userId, @PathVariable boolean completed) {
        alarmService.updateCompletedValue(userId, completed);
        return ResponseEntity.ok("Value updated successfully.");
    }


//        @PutMapping("/status")
//    public void setAlarmStatusByUserId(@RequestParam boolean status){
//        Long userId = getCurrentUserIdFromSession();
//        alarmService.updateCompletedValue(userId, status);
//    }

    private Long getCurrentUserIdFromSession() {
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }
}

