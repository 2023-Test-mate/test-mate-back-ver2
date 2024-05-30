package com.testmateback.domain.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDetailsDTO {
    private final String name;
    private final int grade;
}
