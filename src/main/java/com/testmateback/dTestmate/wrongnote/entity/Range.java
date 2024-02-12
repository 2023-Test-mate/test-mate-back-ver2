package com.testmateback.dTestmate.wrongnote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Range {
    @Id
    @GeneratedValue
    private int rangeId;

    private Long userId;

    private String range;
}
