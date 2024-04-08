package com.testmateback.dTestmate.alarm.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class AlarmDTO {
    private static boolean completed;

    public static boolean isCompleted() {
        return completed;
    }

    public static void setCompleted(boolean completed) {
        AlarmDTO.completed = completed;
    }
}
