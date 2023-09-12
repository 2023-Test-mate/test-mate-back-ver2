package com.testmateback.dTestmate.entity;

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
    private Long id;

    @Column(nullable = false)
    private String indexes;
    @Column(nullable = false)
    private String goal_subject;
    @Column(nullable = false)
    private String goal_semester;
    @Column(nullable = false)
    private String goal;
    @Column(nullable = false)
    private boolean goal_check;

}