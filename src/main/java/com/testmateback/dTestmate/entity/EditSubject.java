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
@Table(name = "edit_subject")
public class EditSubject {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String indexes;
    @Column(nullable = false)
    private String edit_subject;
    @Column(nullable = false)
    private byte[] edit_photo;

}