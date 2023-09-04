package com.testmateback.dTestmate.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

// Lombok 어노테이션을 사용하여 Getter, Setter, Builder 등의 메서드를 자동 생성
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)

// 엔티티 클래스로 지정
@Entity

// JPA 엔티티 리스너를 사용하여 엔티티의 변경 사항을 추적할 수 있도록 설정
@EntityListeners(AuditingEntityListener.class)
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id; // 고유한 식별자로 사용될 필드 (자동 생성 및 증가)

    @Column(nullable = false)
    private String grade; // 등급 정보를 저장하는 필드, null 값 허용하지 않음

    @Column(nullable = false)
    private String name; // 이름 정보를 저장하는 필드, null 값 허용하지 않음

    @Column(nullable = false)
    private String email; // 이메일 정보를 저장하는 필드, null 값 허용하지 않음

    @Column(nullable = false)
    private String password; // 비밀번호 정보를 저장하는 필드, null 값 허용하지 않음
}
