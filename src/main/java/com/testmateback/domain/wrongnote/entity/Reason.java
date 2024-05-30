package com.testmateback.domain.wrongnote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Reason {
    @Id
    @GeneratedValue
    private int reasonId;

    private long userId;
    private String reason;
}
