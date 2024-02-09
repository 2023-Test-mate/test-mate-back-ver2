package com.testmateback.dTestmate.goal;

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
@Table(name = "goal")
public class Goal {
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
    private String goal;
    @Column(nullable = false, unique = false)
    private boolean checks;

    public boolean getCheck() {
        return checks;
    }
}