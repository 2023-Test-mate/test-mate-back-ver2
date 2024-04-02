package com.testmateback.dTestmate.alarm.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "alarm")
public class Alarm {

    @Id
    @GeneratedValue
    private Long alarmId;

    private boolean completed;

    private Long userId;

}
