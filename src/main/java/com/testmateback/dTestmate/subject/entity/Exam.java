package com.testmateback.dTestmate.subject.entity;

import com.testmateback.dTestmate.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String examName;
    private int examScore;

//    @Column(name = "user_id")
//    private Long userId; // 이제 User 객체 대신에 userId를 저장

}