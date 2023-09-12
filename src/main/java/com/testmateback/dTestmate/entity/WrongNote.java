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
@Table(name = "wrong_note")
public class WrongNote {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String indexes;
    @Column(nullable = false)
    private String note_subject;
    @Column(nullable = false)
    private String note_semester;
    @Column(nullable = false)
    private byte[] note_photo;
    @Column(nullable = false)
    private String note_solution;
    @Column(nullable = false)
    private String note_testStyle;
    @Column(nullable = false)
    private String note_reason;
    @Column(nullable = false)
    private String note_testScope;

}