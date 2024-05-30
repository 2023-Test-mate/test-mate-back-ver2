package com.testmateback.domain.calendar.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = false)
    private Long calendarId;
    @Column(nullable = false, unique = false)
    private Long userId;
    @Column(nullable = false, unique = false)
    private String subject;
    @Column(nullable = false, unique = false)
    private LocalDate date;

}