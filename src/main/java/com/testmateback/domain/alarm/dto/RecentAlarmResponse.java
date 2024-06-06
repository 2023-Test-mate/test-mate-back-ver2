package com.testmateback.domain.alarm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecentAlarmResponse {
    private String subject;
    private LocalDate date;
}
