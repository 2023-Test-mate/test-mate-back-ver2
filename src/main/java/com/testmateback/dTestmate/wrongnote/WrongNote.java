package com.testmateback.dTestmate.wrongnote;

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
    private Long id;

    @Column(nullable = false, unique = false)
    private String indexes;
    @Column(nullable = false, unique = false)
    private String subject;
    @Column(nullable = false, unique = false)
    private String grade;
    @Column(nullable = false, unique = false)
    private String title;
    @Column(nullable = false, unique = false)
    private String problem;
    @Column(nullable = false, unique = false)
    private byte[] photo;
    @Column(nullable = false, unique = false)
    private String solution;
    @Column(nullable = false, unique = false)
    private String styles;
    @Column(nullable = false, unique = false)
    private String reason;
    @Column(nullable = false, unique = false)
    private String scopes;
    @Column(nullable = false, unique = false)
    private boolean scopecheck;
    @Column(nullable = false, unique = false)
    private boolean reasoncheck;

    public boolean getReasoncheck() {
        return reasoncheck;
    }

    public boolean getScopecheck() {
        return scopecheck;
    }

}