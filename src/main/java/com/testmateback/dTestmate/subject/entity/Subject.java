package com.testmateback.dTestmate.subject.entity;

import com.testmateback.dTestmate.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue
    private Long subjectId;
    @Column(name = "user_id")
    private Long userId; // 이제 User 객체 대신에 userId를 저장

    private String subjectName;
    private int grade;

    @OneToMany(cascade = CascadeType.ALL)//외래키 설정
    @JoinColumn(name = "subject_id")//subject_id라는 참조키를 가리킨다
    private List<Exam> pastExams;

    private LocalDate date;
    private int goalScore;
    private int level;
    private String comment;
    private String img;
    private int fail;

}
