package com.testmateback.dTestmate.user.entity;

import com.testmateback.dTestmate.util.Encryptor;
import jakarta.persistence.*;
import lombok.*;

// Lombok 어노테이션을 사용하여 Getter, Setter, Builder 등의 메서드를 자동 생성
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = false)
    private String userId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false)
    private int grade;


    public User(String userId, String name, String email, int grade, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.grade = grade;
        this.password = password;
    }

    public User(Long userId) {

    }


    public boolean isMatch(Encryptor encryptor, String password) {
        return encryptor.isMatch(password, this.password);
    }
}
