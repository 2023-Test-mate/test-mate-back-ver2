package com.testmateback.dTestmate.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class Calendar {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String index;
    @Column(nullable = false)
    private String calendar_subject;
    @Column(nullable = false)
    private String calendar_date;

}