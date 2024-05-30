package com.testmateback.domain.alarm;

import com.testmateback.domain.alarm.dao.AlarmStatusResponse;
import com.testmateback.domain.alarm.service.AlarmService;
import com.testmateback.global.message.ResponseMessage;
import com.testmateback.global.message.ResponseMessageType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/alarm")
public class AlarmController {
    private final AlarmService alarmService;

    public AlarmController(AlarmService alarmService) {
        this.alarmService = alarmService;
    }


    @GetMapping("/status")
    public ResponseEntity<AlarmStatusResponse> getAlarmStatusByUserId() {
        AlarmStatusResponse response = alarmService.getAlarmStatusByUserId();
        return ResponseEntity.ok(response);
    }

    @PatchMapping("/check")
    public ResponseEntity<ResponseMessage> updateCompletedValue() {
        alarmService.updateCompletedValue();
        return ResponseEntity.ok(new ResponseMessage(ResponseMessageType.SUCCESS_UPDATE.getMessage()));
    }

}

