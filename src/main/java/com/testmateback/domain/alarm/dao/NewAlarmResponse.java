package com.testmateback.domain.alarm.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewAlarmResponse {
    private String subject;
    private LocalDate date;
}
