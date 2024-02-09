package com.testmateback.dTestmate.user.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginReq {
    private String userId;
    private String password;
}
