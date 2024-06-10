package com.testmateback.domain.wrongnote.entity;

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
@Table(name = "wrongnote")
public class WrongNote {
    @Id
    @GeneratedValue
    @Column(nullable = false, unique = false)
    private Long noteId;

    @Column(nullable = false, unique = false)
    private int subjectId;
    @Column(nullable = false, unique = false)
    private int grade;
    @Column(nullable = false, unique = false)
    private String title;

    private String imgs;
    private String styles;

    @Column(name = "note_reason")
    private String reason;

    @Column(name = "note_range")
    private String range;


}