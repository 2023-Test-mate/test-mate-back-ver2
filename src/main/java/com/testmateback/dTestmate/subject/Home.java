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
@Table(name = "home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동 생성 및 증가
    @Column(nullable = false, unique = false) // 중복 허용
    private Long id;

    @Column(nullable = false, unique = false) // 중복 허용
    private String indexes;

    @Column(nullable = false, unique = false) // 중복 허용
    private String subject;

    @Column(nullable = false, unique = false) // 중복 허용
    private String grade;

    @Column(nullable = false, unique = false) // 중복 허용
    private String fail;
}
