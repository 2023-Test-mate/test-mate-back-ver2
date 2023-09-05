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
public class TestInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String index;
    @Column(nullable = false)
    private String test_subject;
    @Column(nullable = false)
    private String test_semester;
    @Column(nullable = false)
    private int test_score;
    @Column(nullable = false)
    private String test_date;
    @Column(nullable = false)
    private String test_level;
    @Column(nullable = false)
    private int test_target;

}