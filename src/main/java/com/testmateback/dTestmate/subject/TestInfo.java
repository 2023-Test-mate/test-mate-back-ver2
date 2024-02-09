package com.testmateback.dTestmate.subject;

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
    @Column(nullable = false, unique = false)
    private Long id;

    @Column(nullable = false, unique = false)
    private String indexes;
        @Column(nullable = false, unique = false)
    private String subject;
        @Column(nullable = false, unique = false)
    private String grade;
        @Column(nullable = false, unique = false)
    private int score;
        @Column(nullable = false, unique = false)
    private String dates;
        @Column(nullable = false, unique = false)
    private String levels;
        @Column(nullable = false, unique = false)
    private int target;

}