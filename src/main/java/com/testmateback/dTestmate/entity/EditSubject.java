package com.testmateback.dTestmate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class EditSubject {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String index;
    @Column(nullable = false)
    private String edit_subject;
    @Column(nullable = false)
    private String edit_photo;

}