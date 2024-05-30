package com.testmateback.domain.alarm;

import com.testmateback.domain.alarm.service.AlarmService;
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

    @PatchMapping("/check/{userId}")
    public ResponseEntity<String> updateCompletedValue(@PathVariable Long userId) {
        alarmService.updateCompletedValue(userId);
        return ResponseEntity.ok("Value updated successfully.");
    }

    private Long getCurrentUserIdFromSession() {
        Object userIdAttribute = session.getAttribute(LOGIN_SESSION_KEY);

        if (userIdAttribute != null) {
            return (Long) userIdAttribute;
        } else {
            throw new RuntimeException("User not logged in");
        }
    }
}

