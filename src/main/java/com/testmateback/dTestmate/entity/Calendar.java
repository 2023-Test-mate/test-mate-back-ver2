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
@Table(name = "calendar")
public class Calendar {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String indexes;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private String date;

}