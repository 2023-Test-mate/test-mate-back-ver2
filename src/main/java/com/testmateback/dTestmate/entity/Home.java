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
public class Home {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String index;
    @Column(nullable = false)
    private String home_subject;
    @Column(nullable = false)
    private String home_semester;
    @Column(nullable = false)
    private String home_fail;

}
