package com.testmateback.domain.user.dao;

import com.testmateback.domain.user.dto.UserDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String message;
    private UserDetailsDTO userDetails;

    public LoginResponse(String message) {
        this.message = message;
    }

    public LoginResponse(UserDetailsDTO userDetails) {
        this.userDetails = userDetails;
    }
}