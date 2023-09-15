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
@Table(name = "wrongnote")
public class WrongNote {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String indexes;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String grade;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String problem;
    @Column(nullable = false)
    private byte[] photo;
    @Column(nullable = false)
    private String solution;
    @Column(nullable = false)
    private String styles;
    @Column(nullable = false)
    private String reason;
    @Column(nullable = false)
    private String scopes;
    @Column(nullable = false)
    private boolean scopecheck;
    @Column(nullable = false)
    private boolean reasoncheck;

    public boolean getReasoncheck() {
        return reasoncheck;
    }

    public boolean getScopecheck() {
        return scopecheck;
    }

}