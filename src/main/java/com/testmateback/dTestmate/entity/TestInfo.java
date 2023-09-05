package com.testmateback.dTestmate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class TestInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String index;
    @Column(nullable = false)
    private String test_subject;
    @Column(nullable = false)
    private String test_semester;
    @Column(nullable = false)
    private String test_score;
    @Column(nullable = false)
    private String test_date;
    @Column(nullable = false)
    private String test_level;
    @Column(nullable = false)
    private String test_target;

}