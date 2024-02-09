package com.testmateback.dTestmate.user.dto;

import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpReq {
    private  String userId;
    private String name;
    private String email;
    private int grade;
    @Size(min = 8, max = 20, message = "password size must be 8~20")
    private String password;
}
