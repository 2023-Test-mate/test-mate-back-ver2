package com.testmateback.domain.goal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "goal")
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long goalId;

    @Column(nullable = false)
    private int subjectId;
    @Column(nullable = false)
    private int semester;
    @Column(nullable = false)
    private String goalText;
    @Column(nullable = false)
    private boolean completed;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime lastModifiedDate;

}