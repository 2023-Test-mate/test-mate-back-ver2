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
    @GeneratedValue(strategy = GenerationType.IDENTITY)//db의 auto_increment과 같은 역할
    private Long id;

    private String examName;
    private int examScore;

}