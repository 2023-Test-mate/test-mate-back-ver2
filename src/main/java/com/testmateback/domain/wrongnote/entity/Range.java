package com.testmateback.domain.wrongnote.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "ranges")
public class Range {
    @Id
    @GeneratedValue
    private int rangeId;

    private Long userId;

    @Column(name = "ranges")
    private String range;

}
