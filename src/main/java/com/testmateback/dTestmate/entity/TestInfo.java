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
@Table(name = "testinfo")
public class TestInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String indexes;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String grade;
    @Column(nullable = false)
    private int score;
    @Column(nullable = false)
    private String dates;
    @Column(nullable = false)
    private String levels;
    @Column(nullable = false)
    private int target;

}