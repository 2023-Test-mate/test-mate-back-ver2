package com.testmateback.dTestmate.goal.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "goal")
public class Goal {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = false)
    private Long goalId;

    @Column(nullable = false, unique = false)
    private int subjectId;
    @Column(nullable = false, unique = false)
    private int grade;
    @Column(nullable = false, unique = false)
    private String goal;
    @Column(nullable = false, unique = false)
    private boolean completed;

}